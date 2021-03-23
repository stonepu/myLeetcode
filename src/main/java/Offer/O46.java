package Offer;

/**
 * 将数字翻译成字符串的种类
 */
public class O46 {
    public int translateNum(int num) {
        if(num < 10) return 1;
        String str = Integer.valueOf(num).toString();
        char[] arr = str.toCharArray();
        int size = str.length();
        int[] dp = new int[size];
        dp[0] = 1;
        if(arr[0] == '1' || (arr[0] == '2' && arr[1] < '6')) dp[1] = 2;
        else dp[1] = 1;

        for(int i = 2; i < size; i++) {
            if(arr[i - 1] == '1' || (arr[i - 1] == '2' && arr[i] < '6')) dp[i] = dp[i - 1]+ dp[i - 2];
            else dp[i] = dp[i - 1];
        }

        return dp[size - 1];
    }
}
