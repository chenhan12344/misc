package kafka.properties;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;
import java.util.Properties;

/**
 * @date 2023-02-03 17:33
 */
@Slf4j
@Configuration
public class KafkaPropertiesLoader {

    public static final String PROPERTIES_FILE_NAME = "kafka.properties";

    public static final String PROPERTY_BEAN_NAME = "kafkaProperties";

    @Bean(name = PROPERTY_BEAN_NAME)
    public Properties loadProperties() throws Exception {
        String filePath = Objects.requireNonNull(this.getClass().getClassLoader().getResource(PROPERTIES_FILE_NAME)).getPath();

        try (FileReader reader = new FileReader(filePath);
             BufferedReader bufferReader = new BufferedReader(reader)) {
            Properties props = new Properties();
            props.load(bufferReader);
            return props;
        } catch (Exception e) {
            log.error("读取kafka.properties配置文件异常：", e);
            throw new RuntimeException(e);
        }

    }

}
