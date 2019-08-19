package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 44399 on 2019/8/14
 *
 * @author 44399
 */
public class ReentrantLockDemo {

    public static ReentrantLock lock = new ReentrantLock(false);

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyTask(), "A");
        Thread t2 = new Thread(new MyTask(), "B");
        t1.start();
        t2.start();
    }
}

class MyTask implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                ReentrantLockDemo.lock.lock();
                System.out.println(Thread.currentThread().getName() + " got lock and working...");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                ReentrantLockDemo.lock.unlock();
            }
        }
    }
}