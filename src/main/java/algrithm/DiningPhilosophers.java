package algrithm;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

    private ReentrantLock[] locks = {
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock()
    };

    private Semaphore semaphore = new Semaphore(4);
    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        int left = (philosopher + 1) % 5;
        int right = philosopher;

        semaphore.acquire();
        locks[left].lock();
        locks[right].lock();

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putLeftFork.run();
        putRightFork.run();
        locks[right].unlock();
        locks[left].unlock();
        semaphore.release();

    }
}
