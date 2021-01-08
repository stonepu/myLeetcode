package javaKnow;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class OrderedMap {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map =  new TreeMap<>();
        map.put(2, 1);
        map.put(1, 2);
        for(Map.Entry it : map.entrySet()) {
            System.out.println(it.getKey() + "=>" + it.getValue());
        }

        LinkedHashMap<Integer, Integer> hashMap = new LinkedHashMap<>();

        HashMap<Integer, Integer> hMap = new HashMap<>();
    }
}
