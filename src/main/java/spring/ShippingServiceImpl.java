package spring;

/**
 * Created by 44399 on 2019/8/31
 *
 * @author 44399
 */
public class ShippingServiceImpl implements ShippingService {

    @Override
    public void ship(String good) {
        System.out.println(good + " shipped");
    }
}
