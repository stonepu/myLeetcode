package leetCode;

public class T714 {
    //我的解法，超时，时间复杂度O(n*n)
    public int maxProfit(int[] prices, int fee) {
        if(prices.length <= 1) return 0;
        int[] dp = new int[prices.length];
        int outMax = 0;


        for(int i = 1; i < prices.length; i++) {
            int max = Math.max(prices[i] - prices[0] - fee, dp[i - 1]);
            for(int j = 1; j < i; j++) {
                max = Math.max(dp[j - 1] + prices[i] - prices[j] - fee, max);
            }
            dp[i] = max;
            outMax = Math.max(max, outMax);
        }

        return outMax;

    }

    //更巧妙的状态转移方程的设计，内存还可以继续优化，时间复杂度O(n)
    public int maxProfit1(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];
        for(int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];

    }

    public static void main(String[] args) {
        T714 t714 = new T714();
        int[] arr = {4,5,2,4,3,3,1,2,5,4};
        System.out.println(t714.maxProfit(arr, 1));
    }
}
