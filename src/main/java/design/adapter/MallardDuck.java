package design.adapter;

/**
 * Created by DJH on 2019/1/2
 */
public class MallardDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("quack");
    }

    @Override
    public void fly() {
        System.out.println("i am flying");
    }
}
