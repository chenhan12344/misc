package design.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Sky on 2019/6/28
 * CGLIB动态代理
 *
 * @author Sky
 */
public class CglibProxyMethod implements MethodInterceptor {

    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        try {
            before();
            result = methodProxy.invokeSuper(target, args);
            after();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private void before() {
        System.out.println("前置通知");
    }

    private void after() {
        System.out.println("后置通知");
    }
}
