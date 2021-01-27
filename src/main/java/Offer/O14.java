package Offer;

public class O14 {
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        if(n == 4) return 4;
        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        for(int i = 5; i <= n; i++) {
            dp[i] = 3 * dp[i - 3];
        }
        return dp[n];
    }

    public int cuttingRope1(int n) {
        if(n <= 3) return n - 1;
        if(n == 4) return 4;
        long[] dp = new long[n + 1];
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;

        for(int i = 5; i <= n; i++) {
            dp[i] = 3 * dp[i - 3] % 1000000007;
        }
        return (int)dp[n];
    }
}
