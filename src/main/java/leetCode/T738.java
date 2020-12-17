package leetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class T738 {
    public int monotoneIncreasingDigits(int N) {
        if(N < 10) return N;
        int[] arr = getArr(N);
        if(N < getSameLenMinNum(arr.length)) return getMaxNum(arr.length - 1);
        check(arr, arr.length - 1, false);
        int out = 0;
        for(int i = 0; i < arr.length; i++) {
            out += Math.pow(10, i) * arr[i];
        }
        return out;
    }

    public int[] getArr(int N) {
        int tmp = N;
        int len = 0;
        int[] arr = new int[10];
        do{
            arr[len] = tmp % 10;
            ++len;
        }
        while((tmp = tmp / 10) > 0);

        return Arrays.copyOfRange(arr, 0, len);
    }

    public int getSameLenMinNum(int N) {
        if(N == 1) return 1;
        int out = 1;
        int i = 1;
        for(; i < N; ++i) {
            out = out * 10 + 1;
        }
        return out;
    }

    public int getMaxNum(int N) {
        int out = 9;
        for(int i = 1; i < N; ++i) {
            out = out * 10 + 9;
        }
        return out;
    }

    public boolean check(int[] arr, int index, boolean ch) {
        if(index == 0) return true;
        boolean change = ch;
        boolean rst;
        while(arr[index] > arr[index - 1] || !(rst = check(arr, index - 1, change))) {
            if(arr[index] > 0 && (index == arr.length - 1 || arr[index] > arr[index + 1])){
                arr[index] = arr[index] - 1;
                if(!change) {
                    change = true;
                    for(int i = 0; i < index; ++i) {
                        arr[i] = 9;
                    }
                }
            }
            else return false;
        }
        return rst;
    }


    public static void test(int m) {
        m = 10;
        System.out.println(m);
    }

//    public void test1(){}
//
//    public int test1(){return 1;}

    public static void main(String[] args) {
        int a = 9;
        test(a);
        System.out.println("a: " + a);
    }
}
