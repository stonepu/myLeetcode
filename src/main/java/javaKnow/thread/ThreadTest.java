package javaKnow.thread;

import sun.awt.windows.ThemeReader;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class ThreadTest {
    public static void test() throws InterruptedException {
        Object o = new Object();
        synchronized (o) {
            o.notifyAll();
        }


        Thread t = new Thread(()->{
            System.out.println("a new thread");
        });
        t.getState();
        TimeUnit.SECONDS.sleep(1);
        LockSupport.park();
    }

    public static void test2(){
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Thread thread;

    public static void test3(){
        thread = new Thread(()->{
            System.out.println("sleep thread starts");
            try {
                Thread.sleep(1000 * 1000);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
            finally {
                System.out.println("sleep thread over");
            }
        });
        thread.start();

        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("coming into interrupt");
        }
        System.out.println("inter: " + thread.isInterrupted());
        System.out.println("alive: " + thread.isAlive());
        System.out.println("daemon: " + thread.isDaemon());
        thread.interrupt();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("===================");
        System.out.println("inter: " + thread.isInterrupted());
        System.out.println("alive: " + thread.isAlive());
        System.out.println("daemon: " + thread.isDaemon());

    }

    public static void test4(){
        Thread t = new Thread(()->{
            System.out.println("start");
            while(true){
//                System.out.println("thread running");
                if(Thread.interrupted()) {
                    break;
                }
            }
            System.out.println("thread over");
        });

        t.start();
//        t.join();
        try {
            t.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread interrupt");
        t.interrupt();
//        Thread.currentThread().interrupt();
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());
    }

    public static void test5(){
        Object o = new Object();
        synchronized (o){
            System.out.println("lock");
        }
    }

    public static void test6() {
        LockSupport.park();
    }

    public static void test7() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }).start();
    }

    public static void test8() {
        new Thread(()->
                System.out.println("hello2")
        ).start();
    }

    public static void test9() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("s");
    }

    public static void main(String[] args) {
        test7();
        test8();
//        new Object().wait();
        
    }
}
