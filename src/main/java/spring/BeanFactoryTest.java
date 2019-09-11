package spring;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Created by 44399 on 2019/8/31
 *
 * @author 44399
 */
public class BeanFactoryTest {

    public static void main(String[] args) {
        GenericApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfigs.class);
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getBeanFactory();
        beanFactory.autowire(ShippingServiceImpl.class, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, false);
        ShippingService shippingService = applicationContext.getBean(ShippingServiceImpl.class);
        if (shippingService != null) {
            shippingService.ship("iPhone");
        }
        applicationContext.close();
    }
}
