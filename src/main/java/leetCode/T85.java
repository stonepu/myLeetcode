package leetCode;

import java.util.Map;

public class T85 {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if(row == 0) return 0;
        int col = matrix[0].length;
        int[][][] dp = new int[row][col][2];
        int maxArea = 0;
        if(matrix[0][0] == '1') {
            dp[0][0][0] = dp[0][0][1] = 1;
            maxArea = 1;
        }
        for(int i = 1; i < row; i++) {
            if(matrix[i][0] == '0') continue;
            dp[i][0][0] = dp[i - 1][0][0] + 1;
            dp[i][0][1] = 1;
            maxArea = Math.max(maxArea, dp[i][0][0]);
        }

        for(int i = 1; i < col; i++) {
            if(matrix[0][i] == '0') continue;

            dp[0][i][1] = dp[0][i-1][1] + 1;
            dp[0][i][0] = 1;
            maxArea = Math.max(maxArea, dp[0][i][1]);
        }

        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                if(matrix[i][j] == '0') continue;
                dp[i][j][0] = dp[i-1][j][0] + 1;
                dp[i][j][1] = dp[i][j-1][1] + 1;
                int currArea = dp[i][j][0];
                int colIdx = j - 1;
                int minWidth = dp[i][j][0];
                while(colIdx >= 0 && dp[i][colIdx][0] > 0) {
                    if(minWidth > dp[i][colIdx][0]) {
                        maxArea = Math.max(maxArea, currArea);
                        minWidth = dp[i][colIdx][0];
                        currArea = minWidth * (j - colIdx + 1);
                    }
                    else{
                        currArea += minWidth;
                    }
                    --colIdx;
                }

                maxArea = Math.max(maxArea, currArea);
                currArea = dp[i][j][1];
                minWidth = dp[i][j][1];
                int rowIdx = i - 1;
                while(rowIdx >= 0 && dp[rowIdx][j][1] > 0) {
                    if(minWidth > dp[rowIdx][j][1]) {
                        maxArea = Math.max(maxArea, currArea);
                        minWidth = dp[rowIdx][j][1];
                        currArea = minWidth * (i - rowIdx + 1);
                    }
                    else{
                        currArea += minWidth;
                    }
                    --rowIdx;
                }
                maxArea = Math.max(maxArea, currArea);
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        T85 t85 = new T85();
        char[][] arr = {{'0','0','0','0','0','0','1'},{'0','0','0','0','1','1','1'},{'1','1','1','1','1','1','1'},{'0','0','0','1','1','1','1'}};
        System.out.println(t85.maximalRectangle(arr));
    }
}
