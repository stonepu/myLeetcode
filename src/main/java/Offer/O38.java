package Offer;


import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class O38 {
    public String[] permutation(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        List<String> rst = new LinkedList<>();
        rst.add(new String(arr));
        while(hasNext(arr)) {
            rst.add(new String(arr));
            System.out.println(new String(arr));
        }


        return rst.toArray(new String[0]);
    }

    private boolean hasNext(char[] arr) {
        boolean findLess = false;
        int x = -1, y = -1;
        for(int i = arr.length - 1; i > 0; i--) {
            if(arr[i] > arr[i - 1]) {
                x = i - 1;
                findLess = true;
                break;
            }
        }
        if(!findLess) return findLess;

        for(int i = arr.length - 1; i > x; i--) {
            if(arr[i] > arr[x]) {
                swap(arr, x, i);
                sort(arr, x + 1, arr.length - 1);
                break;
            }
        }

        return findLess;
    }

    private void sort(char[] arr, int start, int end) {
        if(start >= end) return;
        int head = start, tail = end;
        while(head < tail) {
            while(head < tail && arr[head] < arr[end]) {
                ++head;
            }

            while(head < tail && arr[tail] >= arr[end]) {
                --tail;
            }

            if(head == tail) break;
            swap(arr, head, tail);

        }
        swap(arr, head, end);
        sort(arr, start, head - 1);
        sort(arr, head + 1, end);
    }

    private void swap(char[] arr, int p, int q) {
        char tmp = arr[p];
        arr[p] = arr[q];
        arr[q] = tmp;
    }

    public static void main(String[] args) {
        String str = "abc";
        O38 o38 = new O38();
        System.out.println(o38.permutation(str));
    }


}
