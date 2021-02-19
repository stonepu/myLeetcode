package javaKnow;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.IntStream;

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

    public static void test2(){
        Deque<Integer> list = new LinkedList<>();
        list.addLast(2);
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        List<String> list1 = new ArrayList<>();
        int[] array = list.stream().mapToInt(Integer::valueOf).toArray();
        System.out.println(list.getClass() == list1.getClass());
        Method add = list1.getClass().getMethod("add", Object.class);
        add.invoke(list1, 123);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.size();
        System.out.println(list1);

        String str = "123";
        Method method = str.getClass().getMethod("length");
        System.out.println(method.invoke(str));
    }
}
