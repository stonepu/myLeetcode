package leetCode;

import java.util.Arrays;

public class T221 {
    public int maximalSquare(char[][] matrix) {
        int w = matrix.length, h = matrix[0].length;
        int[][][] dp = new int[w][h][2];
        int maxLen = 0;
        dp[0][0][0] = dp[0][0][1] = matrix[0][0] == '1' ? 1 : 0;
        for(int i = 1; i < w; i++) {
            if(matrix[i][0] != '0'){
                dp[i][0][1]  = dp[i - 1][0][1] + 1;
                dp[i][0][0] = 1;
            }
        }

        for(int i = 1; i < h; i++) {
            if(matrix[0][i] != '0'){
                dp[0][i][0]  = dp[0][i - 1][0] + 1;
                dp[0][i][1] = 1;
            }
        }
        for(int i = 1; i < w; i++) {
            for(int j = 1; j < h; j++) {
                if(matrix[i][j] == '0') {
                    dp[i][j][0] = dp[i][j][1] = 0;
                }else{
                    dp[i][j][0] = Math.min(dp[i][j - 1][0], dp[i - 1][j - 1][0]) + 1;
                    dp[i][j][1] = Math.min(dp[i - 1][j][1], dp[i - 1][j - 1][1]) + 1;
                    maxLen = Math.max(maxLen, Math.min(dp[i][j][0], dp[i][j][1]));
                }
            }
        }
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                System.out.printf(Arrays.toString(dp[i][j]) + "\t");
            }
            System.out.println();
        }
        return maxLen * maxLen;

    }

    public static void main(String[] args) {
        T221 t221 = new T221();
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
//        String str = "{{\"1\",\"0\",\"1\",\"0\",\"0\"},{\"1\",\"0\",\"1\",\"1\",\"1\"},{\"1\",\"1\",\"1\",\"1\",\"1\"},{\"1\",\"0\",\"0\",\"1\",\"0\"}}";
//        System.out.println(str.replaceAll("\"", "\'"));
        System.out.println(t221.maximalSquare(matrix));
    }
}
