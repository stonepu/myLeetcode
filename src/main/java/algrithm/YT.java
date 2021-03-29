package algrithm;

import java.util.*;

public class YT {


    public static void test1() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while(N > 0) {
            int K = sc.nextInt();
            int[] arr = new int[K];
            for (int i = 0; i < K; i++) {
                arr[i] = sc.nextInt();
            }
            if(t1(arr)) {
                System.out.println("Y");
            }else {
                System.out.println("N");
            }
            --N;
        }
    }

    public static boolean t1(int[] arr) {
        if(arr.length <= 2) {
            return true;
        }
        int index = -1;
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] < arr[i + 1]) {
                if(index != -1) {
                    return false;
                }
                index = i;
            }
        }

        if(index == -1) {
            return true;
        }

        return arr[0] <= arr[arr.length - 1];
    }


    public static void test2() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];


        int[][] dp = new int[N][32];
        long rst = 0;


        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            add(dp, i, arr[i]);
        }

        int target = sc.nextInt();
        int[] targetNum = new int[32];
        int tmp = target;
        for (int i = 0; i < 32; i++) {
            targetNum[i] = tmp % 2;
            tmp /= 2;
        }

        int left = 0, right = 0;

        int[] curr = new int[32];

        while(left < N && right < N) {
            while(check1(dp, right, curr, targetNum) && right < N) {
                right++;
            }

            rst += getN(right - left);
            while(!check(dp, left, curr, targetNum)) {
                left++;
            }

            rst += getN(right - left);
        }

        while(left < N) {
//            rst
        }



        System.out.println(t2(arr, target));
    }

    public static void add(int[][] dp, int index, int num) {
        for (int i = 0; i < 32; i++) {
            dp[index][i] = num % 2;
            num /= 2;
        }
    }

    public static boolean check(int[][] dp, int index, int[] arr, int[] target) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] -= dp[index][i];
        }
        return check(arr, target);
    }

    public static boolean check1(int[][] dp, int index, int[] arr, int[] target) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += dp[index][i];
        }
        return check(arr, target);
    }

    public static boolean check(int[] arr, int[] target) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < target[i]){
                return false;
            }
        }

        return true;
    }

    public static long getN(long n) {
        return (n * n + n) / 2;
    }

    public static int t2(int[] arr, int target) {
        int len = arr.length;
//        int[][] dp = new int[len][len];
        long rst = 0;
        for (int i = 0; i < len; i++) {
            int val = 0;
            for (int j = i; j < len; j++) {
                val |= arr[j];
                if(val > target) {
                    break;
                }

                rst++;

            }
        }

        int mod = 1000000007;
        return (int)(rst % mod);
    }

    public static void main(String[] args) {
//        test1();
        test2();
    }
}
