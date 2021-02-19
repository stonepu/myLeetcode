package javaKnow.thread;

import java.util.concurrent.FutureTask;

public class FutureTaskTest {

    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask<>(() ->{
            return 1;
        });

        Thread t = new Thread(task, "");
    }
}
