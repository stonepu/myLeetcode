package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class T76 {
    public String minWindow(String s, String t) {
        HashSet<Character> set = new HashSet();
        HashMap<Character, Integer> map = new HashMap();
        HashMap<Character, Integer> sMap = new HashMap();
        char[] tArray = t.toCharArray();
        char[] sArray = s.toCharArray();


        for(char ch : tArray) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int head = 0, tail = 0, minLen = Integer.MAX_VALUE, minHead = 0;
        for(int i = 0; i < sArray.length; i++) {
            tail = i;
            sMap.put(sArray[i], sMap.getOrDefault(sArray[i], 0) + 1);
            if(!map.containsKey(sArray[i])) continue;
            while(check(sArray, sMap, map, head, tail)) {
                if(tail - head + 1 < minLen) {
                    minLen = tail - head + 1;
                    minHead = head;
                }
                sMap.put(sArray[head], sMap.getOrDefault(sArray[head], 1) - 1);
                head++;

            }
        }

        if(minLen == Integer.MAX_VALUE) return "";
        return s.substring(minHead, minHead + minLen);

    }

    public boolean check(char[] sArray, HashMap<Character, Integer> sMap, HashMap<Character, Integer> tmap, int head, int tail) {
        for(char ch : tmap.keySet()) {
            if(!sMap.containsKey(ch) || sMap.get(ch) < tmap.get(ch)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        T76 t76 = new T76();
        int i = Integer.bitCount(8);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(Map.Entry entry : hashMap.entrySet()){
            entry.getKey();
            entry.getKey();
        }
        System.out.println(i);
        System.out.println(t76.minWindow("aa", "aa"));
    }
}
