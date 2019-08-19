package thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by 44399 on 2019/8/17
 *
 * @author 44399
 */
public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Callable<Integer>> taskList = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            taskList.add(new MySumTask());
        }
        List<Future<Integer>> futures = executorService.invokeAll(taskList);
        for (Future<Integer> future : futures) {
            System.out.println(future.get());
        }
        executorService.shutdown();
    }


}


class MySumTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Random random = new Random();
        int upper = random.nextInt(1000000);
        int sum = 0;
        for (int i = 0; i < upper; i++) {
            sum += i;
        }
        Thread.sleep(10000);
        System.out.println(Thread.currentThread().getName() + " done.");
        return sum;
    }
}