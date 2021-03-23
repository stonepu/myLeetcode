package javaKnow.statics;

public class StaticTest {



    static {
        m = 200;
    }

    static int m = 100;
}

class Test{
    public static void main(String[] args) {
        System.out.println(StaticTest.m);
    }
}
