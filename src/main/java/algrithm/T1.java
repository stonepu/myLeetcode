package algrithm;

import java.util.*;

public class T1 {
}


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int mod = 1000000007;
        while (K > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
//            System.out.println(n);
//            System.out.println(m);
//            System.out.println(k);

            if (n * m < k) {
                System.out.println(0);
                K--;
                continue;
            }

            long[][] dp = new long[n][n * m + 1];
            for (int i = 1; i <= m; i++) {
                dp[0][i]++;
            }

            for(int i = 1; i < n; i ++) {
                for(int j = 1; j <= n * m; j++) {
                    if(dp[i - 1][j] == 0) {
                        continue;
                    }
                    for(int x = 1; x <= m; x++) {
                        if(j + x > k) {
                            break;
                        }
                        dp[i][j + x] += dp[i - 1][j];
                    }
                }
            }


            System.out.println(dp[n - 1][k] % mod);

            K--;
        }
    }
}

class Solution{

    private int rst = 0;
    public int find(int n, int m, int k) {
        search(n, m, k, 0);
        return rst;
    }

    public void search(int n, int m, int k, int index) {
        if(index == n) {
            if(k == 0) {
                rst++;
            }
        }

        if(k < 0){
            return;
        }

        for(int i = 1; i <= m; i++) {
            search(n, m, k - i, index+1);
        }
    }

}