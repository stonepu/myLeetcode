package bd;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 大数相加，字符串类型的数字相加
 */

public class Nc1 {
    public String solve (String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if(len1 == 0) return t;
        if(len2 == 0) return s;
        int minLen = Math.min(len1, len2);
        int maxLen = Math.max(len1, len2);

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int plus = 0;
        char[] rst = new char[Math.max(len1, len2) + 1];
        for(int i = 1; i <= Math.min(len1, len2); i++) {
            int left = sArray[len1 - i] - '0';
            int right = tArray[len2 - i] - '0';
            if(left + right + plus < 10) {
                rst[rst.length - i] = Integer.toString(left + right + plus).charAt(0);
                plus = 0;
            }else{
                rst[rst.length - i] = Integer.toString((left + right + plus) % 10).charAt(0);
                plus = 1;
            }
        }

        if(len1 != len2) {
            char[] targetArr = len1 > len2 ? sArray : tArray;
            for(int i = 1; i <= maxLen - minLen; i++) {
                rst[rst.length - minLen - i] = Integer.toString(
                        (targetArr[maxLen - minLen - i] - '0' + plus) % 10).charAt(0);
                plus = targetArr[maxLen - minLen - i] - '0' + plus >= 10 ? 1 : 0;
            }
        }
        String res = new String(rst, 1, maxLen);
        if(plus == 1) return plus + res;
        else return res;
    }

    public static void test() {
        String str1 = "-123";
        String str2 = "234";

        BigDecimal bigDecimal1 = new BigDecimal(str1);
        BigDecimal bigDecimal2 = new BigDecimal(str2);

        BigDecimal add = bigDecimal1.add(bigDecimal2);
        System.out.println(add.toString());

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n + 1];
        int[] pi = new int[n];
        int mod = 1000000007;
        for(int i = 1; i < n + 1; i++) {
            pi[i - 1] = sc.nextInt();
            dp[i] = dp[i-1] *2 - dp[pi[i - 1] - 1] +2;
//             dp[i] = (int)(
//                 ((long)dp[i - 1] * 2 - (long)dp[pi[i - 1] - 1] + 2) % 1000000007)
//                 ;

        }

        System.out.println(dp[n] % mod);
    }

//    public static void main(String[] args) {
////        String s = "1";
////        String t = "99";
////        Nc1 nc1 = new Nc1();
////        String solve = nc1.solve(s, t);
////        System.out.println(solve);
//
//        test();
//    }
}
