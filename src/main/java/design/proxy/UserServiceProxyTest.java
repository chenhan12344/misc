package design.proxy;

/**
 * Created by Sky on 2019/6/28
 *
 * @author Sky
 */
public class UserServiceProxyTest {

    public static void main1(String[] args) {
        IUserService userService = new UserServiceImpl();
        UserServiceProxy proxy = new UserServiceProxy(userService);
        proxy.saveUser("Jack");
        proxy.deleteUserById(2L);
        proxy.listAllUser();
    }

    public static void main2(String[] args) {
        ProxyFactory factory = new ProxyFactory();
        IUserService userService = (IUserService) factory.getProxyInstance(new UserServiceImpl());
        userService.saveUser("Jack");
        userService.listAllUser();
        userService.deleteUserById(2L);
    }

    public static void main(String[] args) {
        CglibProxyFactory factory = new CglibProxyFactory();
        IUserService userService = (IUserService) factory.getCglibProxyInstance(new UserServiceImpl());
        userService.saveUser("Jack");
        userService.listAllUser();
        userService.deleteUserById(2L);
    }
}
