package design.proxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by Sky on 2019/6/28
 * CGLIB代理工厂
 *
 * @author Sky
 */
public class CglibProxyFactory {

    /**
     * @param target
     * @return
     */
    public Object getCglibProxyInstance(Object target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new CglibProxyMethod());
        return enhancer.create();
    }
}
