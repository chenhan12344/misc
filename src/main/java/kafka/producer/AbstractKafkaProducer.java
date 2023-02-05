package kafka.producer;

import com.sf.kafka.api.produce.KeyedBytes;
import com.sf.kafka.api.produce.ProduceConfig;
import com.sf.kafka.api.produce.ProduceOptionalConfig;
import com.sf.kafka.api.produce.ProducerPool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Kafka生产者基类
 *
 * @date 2023-01-17 10:01
 */
@Slf4j
public abstract class AbstractKafkaProducer<T> implements InitializingBean, DisposableBean {

    /**
     * 内部生产者
     */
    private ProducerPool producerPool;

    /**
     * 消息主题
     */
    private String topic;

    /**
     * 消息编码，由子类实现
     *
     * @param message 消息体
     * @return 编码后的字节组数
     */
    abstract protected byte[] encode(T message);

    /**
     * 获取生产者配置
     *
     * @return 生产者配置
     * @see ProduceConfig
     */
    abstract protected ProduceConfig getProduceConfig();

    /**
     * 获取生产者自定义配置
     *
     * @return 生产者自定义配置
     * @see ProduceOptionalConfig
     */
    protected ProduceOptionalConfig getProduceOptionalConfig() {
        return ProduceOptionalConfig.defaultConfig;
    }

    /**
     * 发送消息（不指定Key，由Kafka自动计算分区）
     *
     * @param message 消息体
     */
    public void sendMessage(T message) {
        byte[] messageBytes = this.encode(message);
        producerPool.sendBytes(this.topic, messageBytes);
    }

    /**
     * 发送消息（指定Key，同一Key将会被发送至同一分区，用于消息保序）
     *
     * @param key     消息Key
     * @param message 消息体
     */
    public void sendKeyedMessage(String key, T message) {
        byte[] messageBytes = this.encode(message);
        KeyedBytes keyedBytes = new KeyedBytes(key, messageBytes);
        producerPool.sendKeyedBytes(this.topic, keyedBytes);
    }

    /**
     * 初始化内部生产者
     */
    private void initProducer() {
        ProduceConfig produceConfig = this.getProduceConfig();
        this.topic = produceConfig.getTopicTokens().split(":")[0];
        try {
            this.producerPool = new ProducerPool(produceConfig);
            log.info("Kafka生产者注册成功，主题：{}", this.topic);
        } catch (Exception e) {
            log.error("Kafka生产者注册失败，主题：{}", this.topic, e);
        }
    }

    /**
     * 销毁内部生产者
     */
    private void closeProducer() {
        if (this.producerPool == null) {
            return;
        }

        try {
            this.producerPool.close();
        } catch (Exception e) {
            log.warn("关闭Kafka生产者异常，主题：{}", this.topic, e);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.initProducer();
    }

    @Override
    public void destroy() throws Exception {
        this.closeProducer();
    }
}
