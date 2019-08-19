package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by 44399 on 2019/8/16
 *
 * @author 44399
 */
public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Long> futureTask = new FutureTask<>(new SumTask());
        new Thread(futureTask).start();
        Thread.sleep(2000);
        futureTask.cancel(true);
        System.out.println(futureTask.get());
    }

}

class SumTask implements Callable<Long> {

    @Override
    public Long call() {
        long sum = 0;
        for (long i = 0; i < 1000000000; i++) {
            sum += i;
        }
        System.out.println("Work done.");
        return sum;
    }
}
