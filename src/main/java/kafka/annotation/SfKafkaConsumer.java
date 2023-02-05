package kafka.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @date 2023-02-03 17:20
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface SfKafkaConsumer {

    /**
     * 配置前缀
     *
     * @return 配置前缀
     */
    String configPrefix();
}
