package algrithm;

public class FizzBuzz {

    private int n;

    private volatile int printNum = 1;

    private volatile boolean fizzFlag = false;

    private volatile boolean buzzFlag = false;

    private volatile boolean fbFlag = false;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        int end = n % 15 == 0 ? n - 3 : n / 3 * 3;
        while(end >= 3 && printNum <= end) {
            synchronized(this) {
                while(!fizzFlag) {
                    this.wait();
                }

                printFizz.run();
                ++printNum;
                fizzFlag = false;
                this.notifyAll();
            }
        }

    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        int end = n % 15 == 0 ? n - 5 : n / 5 * 5;
        while( end >= 5 && printNum <= end) {
            synchronized(this) {
                // || (printNum % 15 == 0 && printNum % 5 != 0)
                while(!buzzFlag) {
                    this.wait();
                }

                printBuzz.run();
                ++printNum;
                buzzFlag = false;
                this.notifyAll();
            }
        }

    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while( n >= 15 && printNum <= n / 15 * 15) {
            synchronized(this) {
                while(!fbFlag && printNum % 15 != 0) {
                    this.wait();
                }

                printFizzBuzz.run();
                ++printNum;
                fbFlag = false;
                this.notifyAll();
            }
        }

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= n; i++) {
            synchronized(this) {
                while(fizzFlag || buzzFlag || fbFlag) {
                    this.wait();
                }

                if(i % 3 != 0 && i % 5 != 0) {
                    printNumber.accept(i);
                    continue;
                }else if(i % 3 == 0 && i % 5 == 0){
                    printNum = i;
                    fbFlag = true;
                }else if(i % 3 == 0) {
                    printNum = i;
                    fizzFlag = true;
                }else{
                    printNum = i;
                    buzzFlag = true;
                }

                this.notifyAll();

            }
        }

    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> {
                    System.out.println("fizz, ");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("fizz over");
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> {
                    System.out.println("buzz, ");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("buzz over");
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> {
                    System.out.println("fizzbuzz, ");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("fb over");
        }).start();

        new Thread(() -> {
            IntConsumer intConsumer = new IntConsumer();
            try {
                fizzBuzz.number(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("num over");
        }).start();
    }
}
