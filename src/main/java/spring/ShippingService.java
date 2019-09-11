package spring;

/**
 * Created by 44399 on 2019/8/31
 *
 * @author 44399
 */
public interface ShippingService {

    default void ship(String good) {
        System.out.println("nothing shipped");
    }
}
