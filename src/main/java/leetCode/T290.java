package leetCode;

import java.util.HashMap;

public class T290 {

    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap();
        String[] arr = s.split(" ");
        char[] chArr = pattern.toCharArray();

        if(arr.length != chArr.length) return false;
        for(int i = 0; i < chArr.length; i++) {
            if(map.containsKey(chArr[i])) {
                if(!map.get(chArr[i]).equals(arr[i])) return false;
            }else{
                if(map.containsValue(arr[i])) return false;
                map.put(chArr[i], arr[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
