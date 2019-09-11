package spring;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 44399 on 2019/8/31
 *
 * @author 44399
 */
public class MessageServiceImpl implements MessageService {

    private ExecutorService pool;

    public MessageServiceImpl() {
        init();
    }

    private void init() {
        System.out.println("starting thread pool...");
        pool = Executors.newSingleThreadExecutor();
        System.out.println("thread pool started.");
    }

    @Override
    public String getMessage() {
        return "hello world";
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("shutting down thread pool...");
        pool.shutdown();
        System.out.println("thread pool shutdown.");
        pool = null;
        System.out.println("message service destroyed");
    }
}
