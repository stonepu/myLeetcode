package javaKnow.classtest;

import java.text.SimpleDateFormat;

public class ClassTest {
    static int i = 10;

    static {
        i = 20;
    }

    static {
        i = 30;
    }

    public static void main(String[] args) {

    }
}

class SimpleTest {
    public void test1(){}

    private void test2(){}

    public static Object test3(){return new Object();}

    public static void main(String[] args) {
        SimpleTest simpleTest = new SimpleTest();
        simpleTest.test1();
        simpleTest.test2();
        simpleTest.test3();

        SimpleTest.test3();
    }
}


