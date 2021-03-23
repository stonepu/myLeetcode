package algrithm;

import java.util.Arrays;

public class TickTest {
}


class Main1{
    public int getMinTickets(int[] arr) {
        int[] help = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            help[i] = getMindNeed(arr[i]);
        }

        Arrays.sort(help);
        int rst = 0;
        for (int i = 0; i < help.length / 2; i++) {
            rst += help[i];
        }

        return rst;
    }

    private int getMindNeed(int item) {
        int tmp = (int)Math.sqrt(item);
        if(tmp * tmp == item) {
            return 0;
        }

        return Math.min(item - tmp * tmp, (tmp + 1) * (tmp + 1) - item);
    }

    public static void main(String[] args) {

    }
}
