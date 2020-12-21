package leetCode;

public class T5 {
    //中心扩散法
    public String longestPalindrome(String s) {
        if(s.length() <= 1) {
            return s;
        }

        int first = 0;
        int maxLen = 0;

        char[] charArray = s.toCharArray();
        for(int i = 1; i < charArray.length; i++) {
            int singleLen = getSinglePalindrome(charArray, i);
            if(singleLen > maxLen) {
                maxLen = singleLen;
                first = i - maxLen / 2;
            }

            if(charArray[i] == charArray[i - 1]) {
                int doubleLen = getDoublePalindrome(charArray, i - 1);
                if(doubleLen > maxLen) {
                    maxLen = doubleLen;
                    first = i - 1 - (doubleLen - 2) / 2;
                }
            }
        }

        System.out.println("first" + first);
        System.out.println("len: " + maxLen);

        return s.substring(first, first + maxLen);


    }

    public int getSinglePalindrome(char[] arr, int centerIndex){
        int len = Math.min(centerIndex, arr.length - centerIndex - 1);
        int rst = 1;
        for(int i = 1; i <= len; i++) {
            if(arr[centerIndex - i] == arr[centerIndex + i]) {
                rst += 2;
            }else{
                return rst;
            }
        }
        return rst;
    }

    public int getDoublePalindrome(char[] arr, int centerLIndex) {
        int len = Math.min(centerLIndex, arr.length - centerLIndex - 2);
        int rst = 2;
        for(int i = 1; i <= len; i++) {
            if(arr[centerLIndex - i] == arr[centerLIndex + i + 1]) {
                rst += 2;
            }else{
                return rst;
            }
        }
        return rst;
    }


    //动态规划
    public String longestPalindrome1(String s) {
        if(s.length() <= 1) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int length = s.length();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int begine = 0;

        for(int j = 0; j < length; j++) {
            for(int i = 0; i < j; i++) {
                if(j - i == 1 || j - i == 2) {
                    dp[i][j] = charArray[i] == charArray[j];
                }else {
                    dp[i][j] = dp[i + 1][j - 1] && charArray[i] == charArray[j];
                }
                if(dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begine = i;
                }
            }
        }

        return s.substring(begine, begine + maxLen);
    }

    public static void main(String[] args) {
        T5 t5 = new T5();
        String str = "aacabdkacaa";
        new StringBuffer().append('a');
        new StringBuilder().append('a');
        System.out.println(t5.longestPalindrome(str));
    }
}
