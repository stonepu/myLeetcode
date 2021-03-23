package javaKnow.thread.LockTest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        CyclicBarrier barrier = new CyclicBarrier(2, () -> {
            System.out.println("t1 t2 over");
        });

        for (int i = 0; i < 3; i++) {
            service.submit(() ->{
                System.out.println("t1 start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    barrier.await();
                    System.out.println("t1 over");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });

            service.submit(() ->{
                System.out.println("t2 start");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    barrier.await();
                    System.out.println("t2 over");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        service.shutdown();
    }
}
