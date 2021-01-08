package leetCode;

import java.util.Arrays;
import java.util.Map;

public class T152 {
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][3];
        dp[0][0] = dp[0][2] = nums[0];
        dp[0][1] = Math.max(0, dp[0][0]);
        dp[0][2] = Math.min(0, dp[0][0]);

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > 0) {
                dp[i][0] = Math.max(nums[i], Math.max(dp[i-1][0], nums[i] * dp[i-1][1]));
                dp[i][1] = Math.max(nums[i], nums[i]*dp[i-1][1]);
                dp[i][2] = nums[i] * dp[i-1][2];
            }else if(nums[i] < 0) {
                dp[i][0] = Math.max(nums[i], Math.max(dp[i-1][0], nums[i] * dp[i-1][2]));
                dp[i][1] = nums[i]*dp[i-1][2];
                dp[i][2] = Math.min(nums[i], nums[i] * dp[i-1][1]);
            }else{
                dp[i][0] = Math.max(0, dp[i-1][0]);
                dp[i][1] = dp[i][2] = 0;
            }

        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[nums.length - 1][0];
    }

    public static void main(String[] args) {
        T152 t152 = new T152();
        int[] arr = {1, 0, -1, 2, 3, -5, -2};
        int[] arr1 = {1, -2, 3, -4, -3, -4, -3};

        t152.maxProduct(arr1);
    }
}

