package leetCode;

public class T494 {
    public int findTargetSumWays(int[] nums, int S) {
        int total = 0;
        for(int it : nums) {
            total += it;
        }
        if(total < S || 0 - total > S) return 0;
        int target = 2*total + 1;

        int[][] dp = new int[nums.length][target];
        ++dp[0][total-nums[0]];
        ++dp[0][total+nums[0]];
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = 0; j < target; j++) {
                if(dp[i][j] > 0) {
                    dp[i+1][j + nums[i + 1]] += dp[i][j];
                    dp[i+1][j - nums[i + 1]] += dp[i][j];
                }
            }
        }
        return dp[nums.length - 1][total + S];
    }

    public static void main(String[] args) {
        T494 t494 = new T494();
        int[] arr = {0,0,0,0,0,0,0,0,1};
        System.out.println(t494.findTargetSumWays(arr, 1));
    }
}
