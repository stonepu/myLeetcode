package javaKnow.thread.threadPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolTest {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(4);
        System.out.println(pool.invoke(new MyTask(5)));

    }
}

class MyTask extends RecursiveTask<Integer> {

    private int n;

    public  MyTask(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if(n == 1) return 1;

        MyTask t1 = new MyTask(n - 1);
        t1.fork();

        int result = n + t1.join();
        return result;
    }
}
