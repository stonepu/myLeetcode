package leetCode;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class T139 {

    public boolean wordBreak(String s, List<String> wordDict) {
//        for(String it : wordDict) {
//            if(s.startsWith(it)){
////                String[] strArr = s.split(it);
//                if(findStr(s.substring(it.length()), wordDict)) return true;
//            }
//        }
//        return false;

        int dp[] = new int[s.length()];
        HashSet<String> set = new HashSet<>();

        for(String it : wordDict) {
            set.add(it);
        }
        dp[0] = set.contains(s.substring(0, 1)) ? 1 : 0;



        for(int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if((set.contains(s.substring(j + 1, i + 1)) && dp[j] != 0) || set.contains(s.substring(0, i + 1))) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[s.length() - 1] == 1;
    }

    public boolean findStrArr(String[] strArr, List<String> wordDict) {
        if(strArr.length == 0) return true;
        boolean find = false;
        for(String str : strArr) {
            if(str.equals("")) continue;
            find = false;
            for(String it : wordDict) {
                if(str.contains(it)) {
                    String[] subArr = str.split(it);
                    find = findStrArr(subArr, wordDict);
                    break;
                }else{
                    continue;
                }
            }
            if(!find) break;
        }

        return find;
    }

    public boolean findStr(String str, List<String> wordDict) {
        if(str.length() == 0) return true;
        for(String it : wordDict) {
            if(str.startsWith(it)) {
                if(findStr(str.substring(it.length()), wordDict)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "catsandog";
////        List<String> list = n
//        System.out.println(Arrays.asList(str.split("cats")));
        String[] arr = {"cats", "dog", "and", "sand", "cat"};
        T139 t139 = new T139();
        System.out.println(t139.wordBreak(str, Arrays.asList(arr)));


        String str1 = "abcd";
        String[] arr1 = {"a", "abc", "b", "cd"};
        System.out.println(t139.wordBreak(str1, Arrays.asList(arr1)));


        String str2 = "ddadddbdddadd";
        String[] arr2 = {"dd","ad","da","b"};
        System.out.println(t139.wordBreak(str2, Arrays.asList(arr2)));
        List<Integer> list = new LinkedList<>();
        int[] array = list.stream().mapToInt(Integer::valueOf).toArray();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        queue.offer(1);
        queue.offer(1);
        queue.remove(1);
        queue.peek();
        System.out.println(queue.size());
        Deque<Integer> deq = new ArrayDeque<>();
//        deq.pop();
//        deq.peek();
        deq.push(1);
        deq.push(2);
        System.out.println(deq.peek());
    }
}
