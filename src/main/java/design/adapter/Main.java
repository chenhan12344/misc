package design.adapter;

/**
 * Created by DJH on 2019/1/2
 */
public class Main {

    public static void main(String[] args) {
        Turkey turkey = new WildTurkey();
        TurkeyAdapter adapter = new TurkeyAdapter(turkey);
        Duck duck = adapter;
        duck.fly();
        duck.quack();
    }

}
