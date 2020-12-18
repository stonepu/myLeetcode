package bd;

import java.util.HashMap;
import java.util.Scanner;

public class t1 {

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        hashMap.getOrDefault()
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; ++i) {
            String str = sc.next();
            check(str);
        }
    }

    public static void check(String str) {
        if(str.length() <= 2){
            System.out.println(str);
            return;
        }
        int anchor = -2;
        int i = 1;
        while(i < str.length()) {
            if(str.charAt(i) == str.charAt(i - 1)) {
                if(anchor == i - 2 || anchor == i - 1){
                    str = str.substring(0, i) + str.substring(i + 1);
                    continue;
                } else{
                    anchor = i;
                }
            }
            i++;
        }
        System.out.println(str);

    }

}
