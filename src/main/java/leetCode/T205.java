package leetCode;

import java.util.HashMap;

public class T205 {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() == 0) return true;
        HashMap<Character, Character> map = new HashMap();

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        for(int i = 0; i < s.length(); i++) {
            if(sArray[i] == tArray[i]) {
                if(map.getOrDefault(sArray[i], sArray[i]) != sArray[i])
                    return false;
                else
                    map.put(sArray[i], sArray[i]);
            }else{
                if(!map.containsKey(sArray[i])) {
                    if(map.containsValue(tArray[i])) return false;
                    map.put(sArray[i], tArray[i]);
                }
                else if(map.get(sArray[i]) != tArray[i])
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        T205 t205 = new T205();
        System.out.println(t205.isIsomorphic("ab", "ca"));
        System.out.println(t205.isIsomorphic("aa", "ab"));
        System.out.println(t205.isIsomorphic("ab", "aa"));

    }
}
