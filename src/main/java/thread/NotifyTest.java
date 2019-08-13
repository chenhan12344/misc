package thread;

/**
 * Created by 44399 on 2019/8/13
 *
 * @author 44399
 */
public class NotifyTest {

    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();
        new Thread(() -> {
            System.out.println("Thread A trying to get lock");
            synchronized (lock) {
                try {
                    System.out.println("Thread A got lock!");
                    Thread.sleep(1000);
                    System.out.println("Thread A waiting.");
                    lock.wait();    // wait()方法会让线程让出锁，让其他线程去竞争
                    System.out.println("Thread A is working.");
                    Thread.sleep(1000);
                    System.out.println("Thread A done notifying other threads.");
                    lock.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            System.out.println("Thread B trying to get lock");
            synchronized (lock) {
                try {
                    System.out.println("Thread B got lock!");
                    Thread.sleep(1000);
                    System.out.println("Thread B waiting.");
                    lock.wait();    // wait()方法会让线程让出锁，让其他线程去竞争
                    System.out.println("Thread B is working.");
                    Thread.sleep(1000);
                    System.out.println("Thread B done notifying other threads.");
                    lock.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(3000);
        new Thread(() -> {
            System.out.println("Thread C trying to get lock");
            synchronized (lock) {
                try {
                    System.out.println("Thread C got lock");
                    System.out.println("Thread C is working");
                    Thread.sleep(500);
                    System.out.println("Thread C is done");
                    System.out.println("Notifying other threads");
                    lock.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
