package leetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class T179 {
    public String largestNumber(int[] nums) {
//        Arrays.sort(nums, (a, b) -> {
//            String str1 = Integer.valueOf((Integer) a).toString();
//            String str2 = Integer.valueOf((Integer) b).toString();
//            return (str1 + str2).compareTo(str2 + str1);
//        });`
//
//
//        Arrays.sort(nums, (a, b) -> a - b);
        quickSort(nums, 0, nums.length - 1);
        int index = nums.length - 1;
        while(index >= 0 && nums[index] == 0) {
            --index;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = index; i >= 0 ; i--) {
            sb.append(nums[i]);
        }

        if(sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }

    public void quickSort(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }

        int head = start, tail = end;
        while(head < tail) {
            while (head < tail && compare(nums[end], nums[head])) {
                ++head;
            }

            while(head < tail && compare(nums[tail], nums[end])) {
                --tail;
            }

            if(head == tail) {
                break;
            }
            swap(nums, head, tail);
        }
        swap(nums, head, end);
        quickSort(nums, start, head - 1);
        quickSort(nums, head + 1, end);
    }

    public boolean compare(int it1, int it2) {
        String str1 = Integer.valueOf(it1).toString();
        String str2 = Integer.valueOf(it2).toString();

        return (str1 + str2).compareTo(str2 + str1) >= 0;
    }

    public void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }

    public static void main(String[] args) {
        T179 t179 = new T179();
        int[] nums = {3432, 34323};
        System.out.println(t179.largestNumber(nums));

        new PriorityQueue<Integer>((a, b) -> b - a);
    }
}
