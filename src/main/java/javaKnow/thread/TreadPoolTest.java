package javaKnow.thread;

import java.util.concurrent.*;
import java.util.concurrent.Executor;

public class TreadPoolTest {
    public static void test1(){
//        Executor
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 5, 60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5), Executors.defaultThreadFactory());
//        pool.setRejectedExecutionHandler();


        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(1);
        Executors.newScheduledThreadPool(1);
        Executors.newWorkStealingPool();
        for (int i = 0; i < 9; i++) {
            pool.execute(new Task(i));
        }
    }

    public static void test2() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.schedule(()->{

        }, 1, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(()->{

        }, 0, 1, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleWithFixedDelay(()->{

        }, 0, 1, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        test1();
    }

    static class Task implements Runnable{


        int index;

        public Task(int i) {
            this.index = i;
        }
        @Override
        public void run() {
            System.out.println("current thread-" + Thread.currentThread());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
