package javaKnow;

import org.omg.CORBA.INTERNAL;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestString {

    public void test(int a){
        a = 3;
    }

//    public void test1(final int a){
//        a = 3;
//    }

    public static void test3(final int a) {

    }

    public static void main(String[] args) {
        String str1 = "xyz";
        String str2 = "xyz";
        String str3 = new String("xyz");
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        int a = 3;
        test3(a);

        List<Integer> list;
        Set<Integer> set;
        Map<Integer, Integer> map;
    }
}
