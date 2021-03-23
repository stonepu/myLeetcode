package javaKnow.collec;

import sun.nio.cs.ext.GBK;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.locks.Lock;

public class HashMapTest {
    static void test1() throws UnsupportedEncodingException {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.forEach((it, i) ->{

        });
        ByteBuffer bf = ByteBuffer.allocate(10);
        String s = new String(bf.array(), "UTF-8");

//        InputStream
//        Lock lock = new Lock();
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        List<Integer> integers = Collections.synchronizedList(list);
        HashSet<Integer> set = new HashSet<>();
        set.add(1);

        int[] arr = {1, 2, 3};
        List<int[]> list1 = Arrays.asList(arr);
    }
}
