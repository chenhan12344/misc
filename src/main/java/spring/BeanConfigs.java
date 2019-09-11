package spring;

import org.springframework.context.annotation.Bean;

/**
 * Created by 44399 on 2019/8/31
 *
 * @author 44399
 */
public class BeanConfigs {

    @Bean(name = "messageService")
    public MessageService messageService() {
        return new MessageServiceImpl();
    }

    @Bean(name = "goodsService1")
    public GoodsService goodsService1() {
        return new GoodsServiceImpl();
    }

    @Bean(name = "goodsService2")
    public GoodsService goodsService2() {
        return new GoodsServiceImpl();
    }
}
