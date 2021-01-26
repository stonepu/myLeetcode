package Offer;

public class O4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0) return false;
        int col = matrix[0].length;
        if(col == 0) return false;
        int currVal;
        int colIdx = 0;
        int rowIdx = row - 1;
        while(rowIdx >= 0 && colIdx < col) {
            currVal = matrix[rowIdx][colIdx];
            if(currVal == target) return true;
            else if(target > currVal) {
                ++colIdx;
            }else{
                --rowIdx;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        O4 o4 = new O4();
        int[][] arr = {
          {1,   4,  7, 11, 15},
          {2,   5,  8, 12, 19},
          {3,   6,  9, 16, 22},
          {10, 13, 14, 17, 24},
          {18, 21, 23, 26, 30}
        };
        System.out.println(o4.findNumberIn2DArray(arr, 5));
    }
}
