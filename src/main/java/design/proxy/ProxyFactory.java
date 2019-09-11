package design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Sky on 2019/6/28
 * JDK动态代理
 * 只需要实现InvocationHandler接口即可
 * 需要代理对象时，只需要传入被代理的类
 * JDK就会根据委托对象自动创建代理对象
 *
 * @author Sky
 */
public class ProxyFactory implements InvocationHandler {

    /**
     * 被代理对象
     */
    private Object target;

    public Object getProxyInstance(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    /**
     * 方法切面
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            before();

            result = method.invoke(target, args);
            after();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
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
