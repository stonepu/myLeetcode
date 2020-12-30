package leetCode;

import java.util.Arrays;

public class T72 {

    public int minDistance(String word1, String word2) {
        int w = word1.length();
        int h = word2.length();

        if(w == 0) return h;
        if(h == 0) return w;

        char[] wArray1 = word1.toCharArray();
        char[] wArray2 = word2.toCharArray();

        int[][] dp = new int[w][h];
        dp[0][0] = wArray1[0] == wArray2[0] ? 0 : 1;
        boolean findSame = dp[0][0] == 0;

        for(int i = 1; i < h; i++) {
            if(wArray1[0] != wArray2[i] || findSame)
                dp[0][i] = dp[0][i-1] + 1;
            else{
                dp[0][i] = dp[0][i-1];
                findSame = true;
            }
        }

        findSame = dp[0][0] == 0;
        for(int i = 1; i < w; i++) {
            if(wArray1[i] != wArray2[0] || findSame){
                dp[i][0] = dp[i - 1][0] + 1;
            }else{
                dp[i][0] = dp[i - 1][0];
                findSame = true;
            }
        }

        int lastMin, currMin;
        for(int i = 1; i < w; i++) {
            for(int j = 1; j < h; j++) {
                lastMin = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                currMin = wArray1[i] == wArray2[j] ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1;
                dp[i][j] = Math.min(lastMin, currMin);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[w - 1][h - 1];
    }

    public static void main(String[] args) {
        T72 t72 = new T72();
        System.out.println(t72.minDistance("sea", "eat"));
        System.out.println(t72.minDistance("park", "spake"));

    }
}
