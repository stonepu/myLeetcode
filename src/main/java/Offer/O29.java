package Offer;

import java.util.Arrays;

public class O29 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int row = matrix.length;
        int col = matrix[0].length;
        int[] rst = new int[row * col];
        int up = 0, right = col - 1, down = row - 1, left = 0;
        int index = 0;
        while(up < down && right > left) {
            for(int i = left; i < right; i++) {
                rst[index++] = matrix[up][i];
            }

            for(int i = up; i < down; i++) {
                rst[index++] = matrix[i][right];
            }

            for(int i = right; i > left; i--) {
                rst[index++] = matrix[down][i];
            }

            for(int i = down; i > up; i--) {
                rst[index++] = matrix[i][left];
            }

            up++;
            down--;
            left++;
            right--;
        }
        if(index == row * col) return rst;
        if(up == down) {
            for(int i = left; i <= right; i++) {
                rst[index++] = matrix[up][i];
            }
        }else{
            for(int i = up; i <= down; i++) {
                rst[index++] = matrix[i][left];
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        O29 o29 = new O29();
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        System.out.println(Arrays.toString(o29.spiralOrder(arr)));

        int[][] arr1 = {{1}, {3}};
        System.out.println(Arrays.toString(o29.spiralOrder(arr1)));
    }
}
