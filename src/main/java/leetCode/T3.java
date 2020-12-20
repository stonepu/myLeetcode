package leetCode;

import java.util.HashMap;

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
    }
}
