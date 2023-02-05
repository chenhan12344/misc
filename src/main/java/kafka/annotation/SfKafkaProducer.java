package kafka.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @date 2023-02-03 17:24
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface SfKafkaProducer {

    /**
     * 配置前缀
     *
     * @return 配置前缀
     */
    String configPrefix();
}
