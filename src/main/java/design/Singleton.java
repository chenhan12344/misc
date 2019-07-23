package design;

/**
 * Created by Sky on 2019/7/9
 *
 * @author Sky
 */
public class Singleton {

    /**
     * 单例模式中的实例应当用volatile关键字进行修饰
     * 虽然使用双检锁能够有效避免并发下创建实例的问题
     * 但是却无法防止指令重排序问题
     * <p>
     * 对于instance = new Singleton()不属于原子操作，可以拆分成下面三个步骤：
     * 1 -> 为Singleton实例创建空间
     * 2 -> 调用Singleton的构造函数进行初始化
     * 3 -> 将instance指向该实例
     * <p>
     * 由于指令重排序问题，当线程A进入到同步代码块中
     * 就有可能发生1->3->2的重排序问题。
     * 如果线程A执行完3时，发生线程切换，此时线程B访问该对象已不为空
     * 但是该对象尚未进行初始化，将会发生问题
     * 因此需要使用volatile关键字修饰instance，禁止在创建实例时发生指令重排序
     */
    private volatile static Singleton instance;

    /**
     * 单例模式双检锁getInstance写法（通常写法）
     * 既能保证并发，也能保证单例对象的唯一性
     *
     * @return
     */
    public static Singleton getInstance1() {
        if (instance == null) {
            synchronized (Singleton.class) {
                /*
                 * 第二重检查
                 * 因为并发情况下，依然存在多个线程进入到第一个if语句块中的情况
                 * 如果不在同步代码块中进行检查，那么当第一个线程创建完实例时
                 * 后面的线程也会进入到同步代码块中创建实例
                 * 这样就违背了单例模式的设计原则
                 */
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    /**
     * 由于静态内部类不会随着外部类的初始化而初始化
     * 根据类加载机制，只有当需要获得实例的时候才会进行内部类的加载
     * 而类的加载机制由JVM保证线程安全，因此能够确保内部类只加载一次
     */
    private static class Holder {
        private static Singleton instance = new Singleton();
    }

    /**
     * 采用静态内部类持有实例的方法来实现并发安全
     *
     * @return
     */
    private static Singleton getInstance2() {
        return Holder.instance;
    }


    /**
     * 单例模式getInstance基本写法
     * 此方法不能在多线程时保证创建一个对象
     *
     * @return
     */
    public static Singleton getInstance3() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * 单例模式getInstance线程安全写法
     * 此方法能够保证创建一个对象
     * 但是由于对方法进行了加锁，使得多个线程无法同时访问，并发效率低
     *
     * @return
     */
    public synchronized static Singleton getInstance4() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * 单例模式getInstance并发写法（线程不安全）
     * 由于getInstance2()方法并发低，因此
     *
     * @return
     */
    public static Singleton getInstance5() {
        if (instance == null) {
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}
