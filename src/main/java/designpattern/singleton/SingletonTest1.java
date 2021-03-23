package designpattern.singleton;


/**
 * 饿汉式
 * 可用，可能造成内存浪费
 */
public class SingletonTest1 {


}

class Singleton1{
    private Singleton1(){

    }

    private final static Singleton1 instance = new Singleton1();

    public static Singleton1 getInstance() {
        return instance;
    }


}
