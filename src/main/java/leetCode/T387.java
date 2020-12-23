package leetCode;

public class T387 {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        int len = s.length();
        char[] charArray = s.toCharArray();
        for(char ch : charArray) {
            arr[ch - 'a']++;
        }

        for(int i = 0; i < len; i++) {
            if(arr[charArray[i] - 'a'] == 1)
                return i;
        }

        return -1;

    }
}
