package kafka.demo;

import kafka.annotation.SfKafkaConsumer;
import kafka.consumer.AbstractFastjsonKafkaConsumer;
import kafka.dto.UserInfoDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SfKafkaConsumer(configPrefix = "kafka.consumer.user")
public class UserInfoConsumer extends AbstractFastjsonKafkaConsumer<UserInfoDto> {

    @Override
    protected Class<UserInfoDto> getMessageClass() {
        return UserInfoDto.class;
    }

    @Override
    protected void consume(UserInfoDto dto) throws Exception {
        // 消费业务
    }

    @Override
    protected void onConsumeFailed(UserInfoDto message, Throwable e) {
        // 消费异常处理
    }

}
