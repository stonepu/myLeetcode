package leetCode;

import java.util.LinkedList;
import java.util.List;

public class T279 {
    public int numSquares(int n) {
        if (n < 4) return n;
        List<Integer> list = new LinkedList();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            list.add(i * i);
        }

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;
        for (int i = 3; i < n; i++) {
            if ((int)Math.sqrt(i + 1) * (int)Math.sqrt(i + 1) == i + 1) {
                dp[i] = 1;
            } else {
                dp[i] = Integer.MAX_VALUE;
                updateDp(dp, i, list);
            }
        }

        return dp[n - 1];
    }

    public void updateDp(int[] dp, int index, List<Integer> list) {
        for (int it : list) {
            if (index >= it) {
                dp[index] = Math.min(dp[index - it] + 1, dp[index]);
            }
        }
    }

    public static void main(String[] args) {
        T279 t279 = new T279();
        System.out.println(t279.numSquares(12));
    }
}
