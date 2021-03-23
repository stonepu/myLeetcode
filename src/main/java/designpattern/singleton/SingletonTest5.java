package designpattern.singleton;

/**
 * 使用静态内部类进行懒加载，JVM在加载类时保证线程安全
 */
public class SingletonTest5 {
}

class Singleton5{

    private Singleton5(){}

    private static class Singleton5Instance{
        public static final Singleton5 instance = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return Singleton5Instance.instance;
    }
}
