package leetCode;

public class T91 {

    //回溯算法，时间复杂度为指数级别，超时
    public static int numDecodings(String s) {
        if(s.contains("00")) return 0;
        if(s.equals("0")) return 0;
        char[] arr = s.toCharArray();
        return numDecodings(arr, arr.length - 1);
    }

    public static int numDecodings(char[] arr, int index){

        if(index <= 0) return 1;
        int time = 0;

        char curr = arr[index];
        char prev = arr[index - 1];

        if(curr > '0'){
            time += numDecodings(arr, index - 1);
        }

        if(prev == '1' || (curr <= '6' && prev == '2')){
            time += numDecodings(arr, index - 2);
        }


        return time;
    }

    //动态规划，注意分情况讨论，注意特殊情况的处理
    public int numDecodings1(String s) {
        if(s.equals("0") || s.contains("00")) return 0;
        int[] dp = new int[s.length() + 1];
        char[] arr = s.toCharArray();
        if(arr[0] == '0') return 0;
        dp[arr.length - 1] = 1;
        dp[arr.length] = 1;
        //dp[arr.length - 1] = 1;
        for(int i = arr.length - 2; i >= 0; i--) {
            if(arr[i] == '0'){
                if(arr[i - 1] > '2') return 0;
                dp[i] = dp[i+1];
                continue;
            }else{
                if(arr[i] > '2' && arr[i + 1] == '0') return 0;
            }
            if(arr[i] == '1' || (arr[i] == '2' && arr[i + 1] <= '6')){
                dp[i] = dp[i + 2];
                if(arr[i+1] != '0' && (i + 2 == arr.length || arr[i + 2] != '0')) dp[i] =  dp[i] + dp[i + 1];
            }else{
                dp[i] = dp[i + 1];
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(numDecodings("111111111111111111111111111111111111111111111"));
        System.out.println(System.currentTimeMillis() - l);

    }
}
