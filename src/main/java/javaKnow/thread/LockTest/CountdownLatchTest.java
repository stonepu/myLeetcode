package javaKnow.thread.LockTest;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("latch countdown 2 0");
        }).start();

        for (int i = 0; i < 5; i++) {
            int j = i;
            new Thread(() -> {
                System.out.println("running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("countdown " + j);
                countDownLatch.countDown();

            }).start();
        }
    }
}
