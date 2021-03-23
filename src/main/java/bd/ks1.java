package bd;

import java.util.Scanner;

public class ks1 {
    public static int getMatchedSubStr(String bin, int k) {
        char[] arr = bin.toCharArray();
        int rst = 0;
        int currOne = 0;
        int left = 0, right = 0;
        while(left < arr.length) {
            while(currOne <= k && right < arr.length) {
                if(arr[right++] == '1') {
                    ++currOne;
                }

                if(currOne == k) ++rst;
            }

            while(left <= right && currOne >= k) {
                if(arr[left++] == '1') {
                    --currOne;
                }
                if(left > right) break;
                if(currOne == k + 1) ++rst;

            }
            if(right == arr.length) break;
        }
        return rst;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int k = sc.nextInt();
//        sc.nextLine();
//        String bin = sc.nextLine();
//        String bin = "01010";
        String bin = "0010100011";
        int k = 0;
        int rst = getMatchedSubStr(bin, k);
        System.out.println(rst);
    }
}
