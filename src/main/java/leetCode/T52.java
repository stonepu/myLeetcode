package leetCode;

public class T52 {
    int count = 0;

    public int totalNQueens(int n) {
        backtracking(new int[n], 1);
        return count;
    }

    public void backtracking(int[] arr, int row) {
        if(row == arr.length + 1){
            count++;
            return;
        }

        for(int col = 0; col < arr.length; col++) {
            if(arr[col] != 0) continue;
            arr[col] = row;
            if(check(arr, row, col)){
                backtracking(arr, row + 1);
            }
            //回溯
            arr[col] = 0;
        }
    }

    public boolean check(int[] arr, int row, int col){
        if(row == 1) return true;
        for(int i = 0; i < arr.length; i++) {
            if(i == col) continue;
            if(arr[i] > 0) {
                if(row - arr[i] == Math.abs(i - col)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        T52 t52 = new T52();
        System.out.println(t52.totalNQueens(4));
    }
}
