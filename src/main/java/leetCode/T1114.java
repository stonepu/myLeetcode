package leetCode;

import java.util.HashSet;

public class T1114 {

    Object second;
    volatile boolean firstDone;
    volatile boolean secondDone;

    public T1114() {
        second = new Object();
        firstDone = false;
        secondDone = false;
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second.notify();
        firstDone = true;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        if(!firstDone) {
            second.wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }


    public void first() {
        synchronized (second) {
            System.out.println("first done");
            firstDone = true;
            second.notifyAll();
        }
    }

    public void second() {
        synchronized (second) {
            try{
                while(!firstDone)
                    second.wait();
            }
            catch (InterruptedException e) {
                System.out.println("sencod exception");
                e.printStackTrace();
            }
            System.out.println("second donw");
            secondDone = true;
            second.notify();

        }
    }

    public void third() {
        synchronized (second) {
            try{
                while(!secondDone)
                    second.wait();
            }
            catch (InterruptedException e) {
                System.out.println("third exception");
                e.printStackTrace();
            }
            System.out.println("third donw");
        }
    }

    public static void main(String[] args) {
        T1114 t1114 = new T1114();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                t1114.first();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                t1114.second();
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                t1114.third();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try{
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("over");
        }
    }
}
