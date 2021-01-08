package javaKnow;

import java.util.*;

public class ListTest {

    public static void test1(){
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.iterator();
        list1.listIterator();
        list1.get(1);
        List<Integer> integers = Collections.synchronizedList(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.iterator();

    }
    public static void main(String[] args) {

    }
}
