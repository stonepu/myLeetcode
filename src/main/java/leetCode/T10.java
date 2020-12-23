package leetCode;

public class T10 {
    //暴力解法，失败
    public boolean isMatch(String s, String p) {

        char[] sArray = s.toCharArray();

        char[] pArray = p.toCharArray();

        int index = 0;
        while(index < pArray.length){
            if(pArray[index] == '*')
                index++;
            else
                break;
        }


        if(index >= pArray.length) return false;

        for(int i = 0; i < sArray.length; i++) {
            if(index >= pArray.length) return false;

            if(sArray[i] == pArray[index]) {
                index++;
                continue;
            }else if(pArray[index] == '*') {

                if(sArray[i] == sArray[i - 1]){
                    continue;
                }else if(pArray[index - 1] == '.'){
                    return true;
                }
                else{
                    index++;
                    i--;
                    continue;
                }
            }else if(pArray[index] == '.') {
                index++;
                continue;
            }else{
                if(++index >= pArray.length)
                    return false;
                if(pArray[index] == '*') {
                    index++;
                    i--;
                    continue;
                }else{
                    return false;
                }
            }
        }

        if(index < pArray.length - 1) return false;
        return true;
    }

    //动态规划
    public boolean isMatch1(String s, String p) {

        if(s.length() != 0 && p.length() == 0) return false;
        if(s.length() == 0 && p.length() == 0) return  true;
        int sLen = s.length();
        int pLen = p.length();
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        dp[0][1] = pArray[0] == '*' ;
        for(int i = 2; i <= pLen; i++) {
            if(pArray[i - 1] == '*') dp[0][i] = dp[0][i - 2];
            else dp[0][i] = false;
        }

        for (int i = 1; i <= sLen; i++) {
            dp[i][0] = false;
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen ; j++) {
                if(sArray[i - 1] == pArray[j - 1] || pArray[j - 1] == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    if(pArray[j - 1] == '*'){
                        if(dp[i][j - 1]) dp[i][j] = true;
                        else if(j >= 2 && dp[i][j - 2]) dp[i][j] = true;
                        else if(j >= 2 && (sArray[i - 1] == pArray[j - 2] || pArray[j - 2] == '.') && (dp[i - 1][j - 1] || dp[i - 1][j])) dp[i][j] = true;
                        else dp[i][j] = false;
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }

        return dp[sLen][pLen];
    }



    public static void main(String[] args) {
        T10 t10 = new T10();
//        String str1 = "ab";
//        String str2 =  ".*";
        String str1 = "aaa";
        String str2 = ".*";
        System.out.println(t10.isMatch1(str1, str2));
    }
}
