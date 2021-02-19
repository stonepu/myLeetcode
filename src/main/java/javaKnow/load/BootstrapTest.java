package javaKnow.load;

public class BootstrapTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("javaKnow.load.B");
//        System.out.println(aClass.getClassLoader());
    }
}


