package designpattern.singleton;

/**
 * double check lock DCL-线程安全
 */
public class SingletonTest4 {
}

class Singleton4 {
    private volatile static Singleton4 instance;

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }

        }
        return instance;
    }
}



