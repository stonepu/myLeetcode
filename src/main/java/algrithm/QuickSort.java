package algrithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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

        if(tmpH == nums.length - k) {
            return;
        }
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

//        System.out.println(quickSort.quickSort(arr, 5));

        quickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    void sort(int[] arr) {
        quickSort1(arr, 0, arr.length - 1);
    }

    void quickSort1(int[] arr, int head, int tail) {
        if(head >= tail) return;
        int tmpHead = head, tmpTail = tail;
        while(tmpHead < tmpTail){
            while(arr[tmpHead] < arr[tail] && tmpHead < tmpTail) {
                ++tmpHead;
            }

            while(arr[tmpTail] >= arr[tail] && tmpHead < tmpTail) {
                --tmpTail;
            }
            if(tmpHead == tmpTail) {
                break;
            }
            swap(arr, tmpHead, tmpTail);

        }
        swap(arr, tmpHead, tail);
        quickSort1(arr, head, tmpHead - 1);
        quickSort1(arr, tmpHead + 1, tail);
    }
}
