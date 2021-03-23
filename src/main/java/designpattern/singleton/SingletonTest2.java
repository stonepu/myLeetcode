package designpattern.singleton;

/**
 * 饿汉式-静态代码块
 * 可用，可能造成内存浪费
 */
public class SingletonTest2 {
}

class Singleton2{
    private Singleton2(){

    }

    private static Singleton2 instance;

    static {
        instance = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return instance;
    }


}
