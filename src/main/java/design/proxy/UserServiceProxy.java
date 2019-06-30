package design.proxy;

import java.util.List;

/**
 * Created by Sky on 2019/6/28
 * 静态代理
 * 静态代理通过内部持有委托对象的引用，然后委托对象方法进行二次封装
 * 即形成了代理方法。
 * 一般而言，代理对象对外暴露的接口与委托对象是一致的，让客户感觉
 * 不到代理对象与被代理对象的差异。
 * 通过二次封装，避免了源代码的入侵，而且隐藏了委托对象的实现。
 *
 * @author Sky
 */
public class UserServiceProxy {

    /**
     * 被代理对象
     */
    private IUserService userService;

    public UserServiceProxy(IUserService userService) {
        this.userService = userService;
    }

    public int deleteUserById(Long id) {
        before();
        int result = userService.deleteUserById(id);
        after();
        return result;
    }

    public List<String> listAllUser() {
        before();
        List<String> result = userService.listAllUser();
        after();
        return result;
    }

    public void saveUser(String user) {
        before();
        userService.saveUser(user);
        after();
    }

    /**
     * 前置通知
     */
    private void before() {
        System.out.println("performing SQL inject scan...");
    }

    /**
     * 后置通知
     */
    private void after() {
        System.out.println("checking results...");
    }
}
