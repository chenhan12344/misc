import java.util.concurrent.*;

/**
 * Created by Sky on 2019/4/10
 *
 * @author Sky
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws InterruptedException {
        System.out.println("Reading data...");
        Thread.sleep(2000);
        System.out.println("Data read complete!");
        return "hello world";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTask<String> task = new FutureTask<>(new MyCallable());
        new Thread(task).start();
        System.out.println(task.get(1000, TimeUnit.MICROSECONDS));
    }
}
