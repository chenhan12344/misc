/**
 * Created by Sky on 2019/4/14
 *
 * @author Sky
 */
public class JumpGame {

    public static void main(String[] args) throws InterruptedException {
        JumpGame jumpGame = new JumpGame();
        Runnable waitTask = () -> {
            try {
                jumpGame.doWait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " awaken and finished.");
        };

        Runnable notifyTask = jumpGame::doNotify;

        Thread t1 = new Thread(waitTask, "Wait Task 1");
        Thread t2 = new Thread(waitTask, "Wait Task 2");
        Thread t3 = new Thread(waitTask, "Wait Task 3");
        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(1000);
        Thread t4 = new Thread(notifyTask, "Notify Task");
        t4.start();


    }

    public synchronized void doWait() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " got lock and waiting to be awaken.");
        wait();
    }

    public synchronized void doNotify() {
        System.out.println(Thread.currentThread().getName() + " notifies a thread.");
        notifyAll();
    }

    public synchronized void doNotifyAll() {
        System.out.println(Thread.currentThread().getName() + " notifies all thread");
    }
}