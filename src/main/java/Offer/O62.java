package Offer;

import java.util.LinkedList;
import java.util.List;

public class O62 {
    public int lastRemaining(int n, int m) {

        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            list.add(i);
        }
        list.remove(m);
        return -1;
    }

    public static void main(String[] args) {
        int i = 2;
        System.out.println(i << 33);
    }
}
