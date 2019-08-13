import java.util.concurrent.locks.LockSupport;

/**
 * Created by 44399 on 2019/8/13
 *
 * @author 44399
 */
public class MiscTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(MiscTest::doSomething);
        thread.start();
        Thread.sleep(1000);
        LockSupport.unpark(thread);

    }

    private static void doSomething() {
        LockSupport.parkNanos(500000);
        System.out.println("hello");
    }

}
