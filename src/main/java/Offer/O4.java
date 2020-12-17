package Offer;

public class O4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length - 1, n = matrix[0].length - 1;
        if(target > matrix[m][n]) return false;
        if(target == matrix[m][n]) return true;
        int i = 0, j = 0;
        while(true) {
            if(target == matrix[i][j]) return true;
            if(target > matrix[i][j]){
                i = i >= m ? m : i+1;
                j = j >= n ? n : j+1;
                continue;
            }

            if(target == matrix[i][0]) return true;
            else if(target > matrix[i][0]){
                for(int y = 0; y < j; y++) {
                    if(matrix[i][y] == target) return true;
                    else if(matrix[i][y] > target) break;
                }
            }

            if(target == matrix[0][j]) return true;
            else if(target > matrix[0][j]) {
                for(int x = 0; x < i; x++) {
                    if(matrix[x][j] == target) return true;
                    else if(matrix[x][j] > target) break;
                }
            }

            return false;
        }
    }


    public static void main(String[] args) {
        O4 o4 = new O4();
        int[][] arr = {{1, 4}, {2, 5}};
        System.out.println(o4.findNumberIn2DArray(arr, 2));
    }
}
