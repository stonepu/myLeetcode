package leetCode;

import java.util.HashMap;
import java.util.HashSet;

public class T3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap();
        int lastIndex = -1, max = 0;

        for(int i = 0; i < arr.length; i++) {

            if(map.containsKey(arr[i])) {
                if(map.getOrDefault(arr[i], -1) > lastIndex) {
                    lastIndex = map.get(arr[i]);
                }
            }


            max = Math.max(max, i - lastIndex);
            map.put(arr[i], i);
        }

        return max;
    }

    public static void main(String[] args) {
        T3 t3 = new T3();
        System.out.println(t3.lengthOfLongestSubstring("abba"));
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        System.out.println(set.iterator().next());
        set.iterator().next();
        float f = 3.4f;
        short s = 1;
        short 如果 = 1;

        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println(i1 == i2);

        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i3 == i4);
        Integer.valueOf(1);
        String a[];
        String[] ab;
        StringBuilder d;
        char ch = '我';
    }
}
