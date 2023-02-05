package kafka.consumer;

import com.alibaba.fastjson.JSON;

/**
 * 基于Fastjson消息解析的Kafka消费者基类
 *
 * @author 01397356
 * @date 2023-01-13 18:33
 */
public abstract class AbstractFastjsonKafkaConsumer<T> extends AbstractKafkaConsumer<T> {

    abstract protected Class<T> getMessageClass();

    @Override
    protected T decode(byte[] byteMessage) {
        return JSON.parseObject(byteMessage, getMessageClass());
    }
}
