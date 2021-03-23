package algrithm;

public class ZeroEvenOdd {
    private int n;

    volatile private int printNum = 1;

    volatile private boolean print0 = true;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 0; i < n; i++) {
            synchronized(this) {
                while(!print0) {
                    this.wait();
                }
                printNumber.accept(0);

                print0 = false;

                this.notifyAll();
            }
        }


    }

    public void even(IntConsumer printNumber) throws InterruptedException {

        while(this.printNum <= n / 2 * 2) {
            synchronized(this) {

                while(print0 || printNum % 2 != 0) {
                    this.wait();
                }

                printNumber.accept(printNum);

                print0 = true;

                ++printNum;
                this.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {

        int flag = n % 2 == 0 ? n - 1 : n;
        while(printNum <= flag) {
            synchronized(this) {

                while(print0 || printNum % 2 == 0) {
                    this.wait();
                }

                printNumber.accept(printNum);
                print0 = true;

                ++printNum;
                this.notifyAll();
            }


        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        IntConsumer intConsumer = new IntConsumer();
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class IntConsumer{
    public void accept(int x) {
        System.out.println(x);
    }
}