package javaKnow.thread;

import java.util.concurrent.locks.ReentrantLock;

public class reentrantLock {
    public static void test1(){
        ReentrantLock locke = new ReentrantLock(false);
        locke.lock();
        locke.unlock();
    }

    public static void main(String[] args) {
        test1();
    }
}
