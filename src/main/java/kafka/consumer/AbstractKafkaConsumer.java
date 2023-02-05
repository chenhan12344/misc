package kafka.consumer;

import com.alibaba.fastjson.JSON;
import com.sf.kafka.api.consume.ConsumeConfig;
import com.sf.kafka.api.consume.ConsumeOptionalConfig;
import com.sf.kafka.api.consume.IMessageConsumeListener;
import com.sf.kafka.api.consume.KafkaConsumerRegister;
import kafka.annotation.SfKafkaConsumer;
import kafka.properties.KafkaPropertiesLoader;
import kafka.serializer.Decoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Objects;
import java.util.Properties;

/**
 * Kafka消费者基类
 * 设计原则应该让使用方专注于具体消费业务逻辑
 * 其他与消费业务逻辑无关的操作应该都由基类去实现
 *
 * @date 2023-01-13 17:54
 */
@Slf4j
public abstract class AbstractKafkaConsumer<T> implements InitializingBean, DisposableBean, ApplicationContextAware {

    private ApplicationContext applicationContext;

    public static final String CONFIG_SUFFIX_CLUSTER_NAME = ".clusterName";
    public static final String CONFIG_SUFFIX_MONITOR_URL = ".monitorUrl";
    public static final String CONFIG_SUFFIX_TOPIC = ".topic";
    public static final String CONFIG_SUFFIX_SYSTEM_ID_TOKEN = ".systemIdToken";
    public static final String CONFIG_SUFFIX_THREAD_COUNT = ".threadCount";

    /**
     * 消费组ID
     */
    private String systemId;

    /**
     * 消费主题
     */
    private String topic;

    /**
     * 消费业务逻辑
     *
     * @param message 业务消息
     * @throws Exception 消费异常
     */
    protected abstract void consume(T message) throws Exception;

    /**
     * 消费失败时的回调
     * 一般用于日志记录以及异常数据转储
     * 子类实现此方法时应当尽可能避免异常的发生
     *
     * @param message 业务消息
     * @param e       导致失败的异常
     */
    protected void onConsumeFailed(T message, Throwable e) {
    }

    /**
     * 消息解码
     *
     * @param byteMessage 消息字节
     * @return 解析后的对象
     */
    abstract protected T decode(byte[] byteMessage);

    /**
     * 获取消费者配置
     *
     * @return 获取消费者配置
     */
    protected ConsumeConfig getConsumeConfig(Properties kafkaProperties, String configPrefix) {
        String clusterName = kafkaProperties.getProperty(configPrefix + CONFIG_SUFFIX_CLUSTER_NAME);
        String monitorUrl = kafkaProperties.getProperty(configPrefix + CONFIG_SUFFIX_MONITOR_URL);
        String topic = kafkaProperties.getProperty(configPrefix + CONFIG_SUFFIX_TOPIC);
        String systemIdToken = kafkaProperties.getProperty(configPrefix + CONFIG_SUFFIX_SYSTEM_ID_TOKEN);
        int threadCount = Integer.parseInt(Objects.requireNonNull(kafkaProperties.getProperty(configPrefix + CONFIG_SUFFIX_THREAD_COUNT)));

        return new ConsumeConfig(systemIdToken, monitorUrl, clusterName, topic, threadCount);
    }

    /**
     * 其他消费配置
     *
     * @return 其他消费配置
     */
    protected ConsumeOptionalConfig getConsumeOptionalConfig() {
        return ConsumeOptionalConfig.defaultConfig;
    }

    /**
     * 重新注册消费者
     * 适用于动态配置下配置发生变更时需要更新消费者配置
     */
    public void reRegisterConsumer() {
        this.unregisterConsumer();
        this.registerConsumer();
    }

    /**
     * 消费者初始化
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        this.registerConsumer();
    }

    /**
     * 消费者销毁
     *
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        this.unregisterConsumer();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 注册消费者
     */
    private void registerConsumer() {
        Properties kafkaProperties = applicationContext.getBean(KafkaPropertiesLoader.PROPERTY_BEAN_NAME, Properties.class);
        SfKafkaConsumer annotation = this.getClass().getAnnotation(SfKafkaConsumer.class);
        if (annotation == null) {
            throw new RuntimeException("无法获取配置前缀，请使用@SfKafkaConsumer注解标识消费组");
        }

        // 根据配置前缀读取消费配置并注册消费组
        String configPrefix = annotation.configPrefix();
        ConsumeConfig consumeConfig = this.getConsumeConfig(kafkaProperties, configPrefix);

        this.topic = consumeConfig.getTopic();
        this.systemId = consumeConfig.fetchSystemId();

        Decoder<T> decoder = this::decode;
        IMessageConsumeListener<T> listener = (messages) -> {
            for (T message : messages) {
                try {
                    this.consume(message);
                } catch (Exception e) {
                    log.error("Kafka消费异常，主题：{}，消费组ID：{}，消费配置数据：{}", topic, systemId, JSON.toJSONString(messages), e);
                    this.onConsumeFailed(message, e);
                }
            }
        };

        try {
            KafkaConsumerRegister.register(consumeConfig, listener, decoder, this.getConsumeOptionalConfig());
            log.info("Kafka消费者注册成功，主题：{}，消费组ID：{}", topic, systemId);
        } catch (Exception e) {
            log.error("Kafka消费者注册失败，主题：{}，消费组ID：{}", topic, systemId, e);
        }
    }

    /**
     * 反注册消费者
     */
    private void unregisterConsumer() {
        KafkaConsumerRegister.unregister(systemId, topic);
    }
}
