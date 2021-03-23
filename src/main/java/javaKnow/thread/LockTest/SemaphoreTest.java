package javaKnow.thread.LockTest;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4);

        for (int i = 0; i < 10; i++) {
            int j = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "  " + j);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "  over");
                semaphore.release();
            }).start();
        }
    }
}
