package designpattern.singleton;

/**
 * 使用枚举方式来创建单例
 * 多线程安全，能防止反序列化重新创建对象
 */
public class Singleton6Test {
    public static void main(String[] args) {
        Singleton6 instance1 = Singleton6.INSTANCE;
        instance1.sayOK();

        Singleton6 instance2 = Singleton6.INSTANCE;
        System.out.println(instance1 == instance2);

        Runtime runtime = Runtime.getRuntime();

    }
}

enum Singleton6{

    INSTANCE;

    public void sayOK() {
        System.out.println("OK");
    }

}
