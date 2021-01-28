package Offer;

import java.util.Arrays;

public class O19 {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        if (pLen == 0 && sLen != 0) return false;
        if (pLen == 0 && sLen == 0) return true;
        if (sLen == 0) {
            if (pLen == 1 && pArray[0] != '*') return false;
            if (pArray[pLen - 1] != '*') return false;
            for (int i = 0; i < pLen - 1; i++) {
                if (pArray[i] != '*' && pArray[i + 1] != '*') return false;
            }
            return true;
        }
        boolean[][] dp = new boolean[pLen][sLen];

        dp[0][0] = pArray[0] == '.' || sArray[0] == pArray[0];
        boolean find = dp[0][0];
        int test = find ? 0 : (pArray[0] == '*' ? 0 : 1);
        for (int i = 1; i < pLen; i++) {
            if (pArray[i] == '*') {
                if (test > 0) --test;
                if (dp[i - 1][0]) {
                    dp[i][0] = true;
                } else if (i > 1) {
                    dp[i][0] = dp[i - 2][0];
                }
            } else if ((pArray[i] == sArray[0] || pArray[i] == '.')) {
                if (test > 0) test++;
                if (pArray[i - 1] == '*') {
                    if (i > 1) {
                        dp[i][0] = dp[i - 2][0];
                    }
                    if (!find && test <= 0) {
                        find = true;
                        dp[i][0] = true;
                    }
                }

            } else {
                test++;
            }
        }

        if (!find) return false;

        for (int i = 1; i < pLen; i++) {
            for (int j = 1; j < sLen; j++) {
                if (pArray[i] == sArray[j] || pArray[i] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (pArray[i] == '*') {
                    if (dp[i - 1][j] || (i > 1 && dp[i - 2][j])) {
                        dp[i][j] = true;
                    } else if (pArray[i - 1] == sArray[j]) {
                        if (i > 1 && j > 1) {
                            dp[i][j] = dp[i - 2][j - 2];
                        }else{
                            dp[i][j] = true;
                        }
                    } else if(pArray[i - 1] == '.'){
                        dp[i][j] = dp[i][j - 1];
                    }else if (pArray[i - 1] == '*') {
                        dp[i][j] = dp[i - 1][j];
                    } else if (dp[i - 1][j - 1] && (pArray[i - 1] == '.' || pArray[i - 1] == sArray[j])) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        for (boolean[] it : dp) {
            System.out.println(Arrays.toString(it));
        }

        return dp[pLen - 1][sLen - 1];
    }

    public static void main(String[] args) {
        O19 o19 = new O19();
        String s = "acbbcbcbcbaaacaac";
        String p = "ac*.a*ac*.*ab*b*ac";
        System.out.println(o19.isMatch(s, p));

        String s1 = "aaa";
        String p1 = "a*";
        System.out.println(o19.isMatch(s1, p1));

        String s2 = "abcdede";
        String p2 = "ab.*de";
        System.out.println(o19.isMatch(s2, p2));
    }
}
