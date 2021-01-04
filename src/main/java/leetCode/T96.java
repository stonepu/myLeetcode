package leetCode;

import java.util.*;

public class T96 {
    int count = 0;

    public int numTrees(int n) {
        return updateCount(n);
    }

    public int updateCount(int n) {
        if(n < 3 && n > 0) return n;
        if(n <= 0) return 1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += updateCount(n - i - 1) * updateCount(i);
        }
        return count;
    }

    public int numTrees1(int n) {
        int[] G = new int[n + 1];
        G[0] =  G[1] = 1;
        for(int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                G[i] += G[j] * G[i - j - 1];
            }
        }
        return G[n];
    }

    public void updateCount(int n, List<Integer> list, int index) {
        if(!checList(list)) return;
        if(list.size() == n) {
            ++count;
            return;
        }

        for (int i = 0; i < list.size(); i++) {

        }
    }

    public boolean checList(List<Integer> list) {
        if(list.isEmpty() || list.size() <= 2) return true;
        for(int it : list) {

        }
        return false;
    }


    public void test() {
        List<Integer> list = new LinkedList<>();
        list.add(0, 1);
        list.add(0, 2);
        list.add(2,3);
        list.remove(0);
        list.toString();
        System.out.println(list);
    }

    public static void main(String[] args) {
        T96 t96 = new T96();
//        t96.test();
        Deque<Integer> list = new ArrayDeque<>();
        list.push(1);
        list.push(2);
        System.out.println(list.pop());
        System.out.println(Integer.MIN_VALUE);
        System.out.println(t96.numTrees(3));

        System.out.println(Math.round(11.5));
        System.out.println(Math.round(-12.5));
        String a = "123";

//        switch (a) {
//            case "2" :
//                break;
//            case "123":
//                System.out.println("coming");
//                break;
//
//            default:
//                System.out.println("default");
//        }
//
//        byte aa = 's';
//        switch (aa) {
//
//        }
//
//        long l = 123;
//        switch (l) {
//
//        }


    }

}
