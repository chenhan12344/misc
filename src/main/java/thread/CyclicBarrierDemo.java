package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by 44399 on 2019/8/16
 *
 * @author 44399
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(11);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("Thread " + Thread.currentThread().getName() + " arrived at barrier");
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        System.out.println("Main thread arrived at barrier");
        cyclicBarrier.await();
        System.out.println("All thread done!");

    }
}
