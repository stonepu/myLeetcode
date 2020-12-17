package leetCode;

public class T62 {

    int count = 0;

    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m + 1][n + 1];
        arr[m - 1][n - 1] = 0;
        arr[m - 1][n - 2] = 1;
        arr[m - 2][n - 1] = 1;
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j>= 0; j--) {
                if(i == m - 1 && j == n - 2) continue;
                if(i == m-2 && j == n-1) continue;
                arr[i][j]  = arr[i][j+1] + arr[i+1][j];
            }
        }
        return arr[0][0];
    }

    public static void main(String[] args) {
        T62 t62 = new T62();
        System.out.println(t62.uniquePaths(51, 9));
    }
}
