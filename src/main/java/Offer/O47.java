package Offer;

/**
 * 礼物的最大值，简单的动态规划
 */
public class O47 {
    public int maxValue(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];

        dp[0][0] = grid[0][0];
        for(int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for(int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for(int i = 1; i< rows; i++) {
            for(int j = 1; j < cols; j++) {
                dp[i][j] = grid[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        // for(int[] arr : dp) {
        //     System.out.println(Arrays.toString(arr));
        // }

        return dp[rows - 1][cols - 1];

    }
}
