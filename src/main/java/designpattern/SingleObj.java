package designpattern;

public class SingleObj {

    volatile static SingleObj instance;

    private SingleObj(){

    }

    public static SingleObj getInstance() {
        if(instance == null) {
            synchronized (SingleObj.class) {
                if(instance == null) {
                    instance = new SingleObj();
                }
            }
        }

        return instance;
    }
}


/**
 * 适用于静态域
 */
class Singleton{
    private static class SingletonHolder{
        private static final Singleton Instance = new Singleton();
    }

    private Singleton(){

    }

    public static Singleton getInstance() {
        return SingletonHolder.Instance;
    }
}
