package javaKnow.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class reentrantLock {
    public static void test1(){
        ReentrantLock locke = new ReentrantLock(false);
        locke.lock();
        try{
            LockSupport.park();

        }finally {
            locke.unlock();
        }
    }

    public static void test2(){
        ReentrantLock locke = new ReentrantLock(false);
        try {
            locke.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        } finally {
            locke.unlock();
        }
    }

    public static void test3(){
        ReentrantLock locke = new ReentrantLock(false);
        if(!locke.tryLock()) return;

        locke.unlock();
    }

    public static void test4(){
        ReentrantLock locke = new ReentrantLock(false);
        try {
            if(!locke.tryLock(1, TimeUnit.SECONDS)) return;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }finally {
            locke.unlock();
        }
    }


    public static void main(String[] args) {
//        test1();

        Test1 a = ()->{
            System.out.println("aaa");
        };
        a.print();
    }
}

@FunctionalInterface
interface Test1{
    void print();
    default void t(){}
}


