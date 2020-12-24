package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

public class T32 {
    public int longestValidParentheses(String s) {
        int len = s.length();
        if(len <= 1) return 0;
        int max = 0;
        int lastIndex = -1;
        int lastMax = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        Deque<Integer> stack = new ArrayDeque();
        char[] charArray = s.toCharArray();
        for(int i = 0; i < len; i++) {
            if(charArray[i] == '('){
                stack.push(i);
            }else{
                if(stack.isEmpty()) {
                    lastIndex = -1;
                    lastMax = 0;
                    continue;
                }
                int left = stack.pop();
                int currLen = i - left + 1;
                if(map.containsKey(left - 1)) {
                    currLen += map.get(left - 1);
                }
                max = Math.max(max, currLen);
                lastMax = currLen;
                lastIndex = i;

                map.put(i, currLen);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        T32 t32 = new T32();
        System.out.println(t32.longestValidParentheses("()(())"));
    }
}
