package leetCode;

import java.util.Deque;
import java.util.LinkedList;

public class T456 {
    /**
     * 方法一，暴力法，时间复杂度O(n^2)
     * @param nums
     * @return
     */
    public boolean find132pattern1(int[] nums) {
        int len = nums.length;
        if(len < 3) return false;
        int currMin = nums[0];
        int currMaxValidIndex = 0;
        int[][] dp = new int[len][2];

        for(int i = 1; i < len; i++) {
            for(int j = 1; j < i; j++) {
                if(nums[i] < nums[j] &&
                        dp[j][0] == 1 &&
                        nums[i] > dp[j][1]) {
                    return true;
                }
            }

            if(nums[i] > currMin) {
                dp[i][0] = 1;
                dp[i][1] = currMin;
            }else{
                currMin = nums[i];
            }
        }

        return false;
    }

    /**
     * 方法二：枚举3，固定
     * @param nums
     * @return
     */
    public boolean find132pattern2(int[] nums) {
        int len = nums.length;
        if(len < 3) {
            return false;
        }

        int[] leftMin = new int[len];
        leftMin[0] = nums[0];
        int currMin = nums[0];
        for (int i = 1; i < len; i++) {
            leftMin[i] = Math.min(currMin, nums[i]);
        }

        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(nums[len - 1]);
        for (int i = len - 2; i > 0; i--) {
            int right = Integer.MIN_VALUE;
            while (!stack.isEmpty() && stack.peekLast() <  nums[i]) {
                right = stack.pollLast();
            }

            if(right > leftMin[i - 1]) {
                return true;
            }

            stack.addLast(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        T456 t456 = new T456();
//        int[] arr = {2, 4, 6, 3, 1};
            int[] arr = {1,3,2,4,5,6,7,8,9,10};
        System.out.println(t456.find132pattern2(arr));
    }
}
