package algrithm;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class M1 {

    public static int test1(int[] A) {

        if(A.length == 0) {
            return 0;
        }

        int max = 0;
        int curr = 0;

        for (int i = 0; i < A.length; i++) {
            if(A[i] >= 0) {
                curr += A[i];
            }else{
                max = Math.max(max, curr);
                curr = 0;
            }
        }

        max = Math.max(curr, max);

        return max;
    }

    public static int test2(int[] A, int K) {
        if(K >= A.length - 1) {
            return 0;
        }
        Deque<Integer> minStack = new LinkedList<>();
        Deque<Integer> maxStack = new LinkedList<>();

        int leftMax = Integer.MIN_VALUE;
        int leftMin = Integer.MAX_VALUE;

        int minRst = Integer.MAX_VALUE;

        for(int i = A.length - 1; i >= K; i--) {
            if(minStack.isEmpty()) {
                minStack.addLast(A[i]);
            }else{
                minStack.addLast(Math.min(minStack.peekLast(), A[i]));
            }

            if(maxStack.isEmpty()) {
                maxStack.addLast(A[i]);
            }else{
                maxStack.addLast(Math.max(maxStack.peekLast(), A[i]));
            }
        }

        for (int i = 0; i <= A.length - K ; i++) {
            int currMin = minStack.isEmpty() ? leftMin : Math.min(leftMin, minStack.peekLast());
            int currMax = maxStack.isEmpty() ? leftMax : Math.max(leftMax, maxStack.peekLast());

            minRst = Math.min(currMax - currMin, minRst);
            leftMax = Math.max(leftMax, A[i]);
            leftMin = Math.min(leftMin, A[i]);
            minStack.pollLast();
            maxStack.pollLast();
        }

        return minRst;

    }


    public static int test3(int[] A, int M) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int it : A) {
            map.put(it, map.getOrDefault(it, 0) + 1);
            min = Math.min(min, it);
            max = Math.max(max, it);
        }

        int maxLen = 0;

        for (int i = min; i < min + M; i++) {
            int k = 0;
            int currLen = 0;
            while(i + k * M <= max) {
                currLen += map.getOrDefault(i + k * M, 0);
                ++k;
            }

            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 1, 3};
//        System.out.println(test2(arr, 2));

        int[] arr1 = {1};
        System.out.println(test3(arr1, 10));

        System.out.println(-2 % 3);
    }
}
