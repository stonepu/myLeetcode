package algrithm;

import java.util.Arrays;

public class QuickSort {
    public void quickSort(int[] nums, int head, int tail, int k) {
        if(head >= tail) return;
        int tmpH = head;
        int tmpT = tail;
        while(tmpH < tmpT) {
            while(nums[tmpH] < nums[tail] && tmpH < tmpT) {
                tmpH++;
            }

            while(nums[tmpT] >= nums[tail] && tmpT > tmpH){
                tmpT--;
            }

            swap(nums, tmpH, tmpT);

        }

        swap(nums, tmpH, tail);

        if(tmpH == nums.length - k) return;
        else{
            quickSort(nums, head, tmpH - 1, k);
            quickSort(nums, tmpH + 1, tail, k);
        }
    }

    public void swap(int[] nums, int p, int q) {
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }

    public int quickSort(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1, k);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {7,6,5,4,3,2,1};

        System.out.println(quickSort.quickSort(arr, 5));

        System.out.println(Arrays.toString(arr));
    }
}
