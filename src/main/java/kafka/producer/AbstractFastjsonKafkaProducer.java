package kafka.producer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 基于Fastjson的Kafka生产者基类
 *
 * @date 2023-01-17 10:13
 */
public abstract class AbstractFastjsonKafkaProducer<T> extends AbstractKafkaProducer<T> {

    @Override
    protected byte[] encode(T message) {
        return JSON.toJSONBytes(message, SerializerFeature.WriteMapNullValue);
    }
}
