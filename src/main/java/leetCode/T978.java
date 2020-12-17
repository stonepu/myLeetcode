package leetCode;

import java.util.HashMap;

public class T978 {
    //动态规划
    public int maxTurbulenceSize(int[] arr) {
        if(arr.length <= 1) return arr.length;
        if(arr.length == 2) return arr[0] == arr[1] ? 1 : 2;
        int[][] dp = new int[arr.length][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        for(int i = 1; i < arr.length; i++) {
            dp[i][1] = arr[i] > arr[i-1] ? 1 : (arr[i] < arr[i - 1] ? 2 : -1);
        }
        int max = 1;
        for(int i = 2; i < arr.length; i++) {
            if(dp[i][1] == -1) {
                dp[i][0] = Math.max(dp[i - 1][0], 1);
                continue;
            }
            int currLen = 2;
            for(int j = i; j > 1; j--) {
                if(dp[j][1] == -1 || dp[j - 1][1] == -1) break;

                if(dp[j][1] == dp[j - 1][1])
                    break;

                currLen++;
            }
            dp[i][0] = Math.max(dp[i][0], currLen);
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }


    //滑动窗口
    public int maxTurbulenceSize1(int[] arr) {
        if(arr.length <= 1) return arr.length;
        if(arr.length == 2) return arr[0] == arr[1] ? 1 : 2;
        int max = 1;
        int anchor = 0;
        for(int i = 2; i < arr.length; i++) {
            if(arr[i] != arr[i-1]) max = Math.max(2, max);
            if((arr[i] > arr[i - 1] && arr[i - 1] < arr[i-2]) || (arr[i] < arr[i - 1] && arr[i - 1] > arr[i-2])) {
                max = Math.max(max, i - anchor + 1);
            }else{
                anchor = i - 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        T978 t978 = new T978();
        int[] arr = {9,4,2,10,7,8,8,1,9};
        System.out.println(t978.maxTurbulenceSize1(arr));
    }
}
