package javaKnow.thread.LockTest;

import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {

    public static void main(String[] args) {
        StampedLock lock = new StampedLock();
        long l = lock.readLock();

        lock.unlockRead(l);


        //乐观锁
        long l1 = lock.tryOptimisticRead();
        if(!lock.validate(l1)) { //如果乐观读失败，则锁升级
            long l2 = lock.readLock();


            lock.unlockRead(l2);
        }
    }
}
