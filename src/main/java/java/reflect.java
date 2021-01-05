package java;

import java.lang.reflect.Method;

public class reflect {

    void test3(){}

    final void test(){}

    final void test(int a){}

    public static void main(String[] args) throws Exception {
        try{
        String str = "dcda";
        Method split = str.getClass().getMethod("toUpperCase");
        System.out.println(split.invoke(str));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
