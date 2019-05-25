package design.adapter;

/**
 * Created by DJH on 2019/1/2
 */
public class WildTurkey implements Turkey {

    @Override
    public void gobble() {
        System.out.println("gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("i am flying a short distance");
    }
}
