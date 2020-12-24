package leetCode;

import java.util.Arrays;

public class T31 {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;
        int firstIndex = -1;
        int secondeIndex = -1;
        for(int i = nums.length - 1; i > 0; i--) {
            if(nums[i] > nums[i - 1]) {
                firstIndex = i - 1;
                break;
            }
        }

        if(firstIndex == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        for(int i = nums.length - 1; i > firstIndex; i--) {
            if(nums[i] > nums[firstIndex]) {
                secondeIndex = i;
                break;
            }
        }

        if(secondeIndex == -1) {
            secondeIndex = firstIndex + 1;
        }


        exchange(nums, firstIndex, secondeIndex);
        System.out.println("exch" + Arrays.toString(nums));

        reverse(nums, firstIndex + 1, nums.length - 1);
    }

    public void reverse(int[] nums, int head, int tail) {
        if(head >= tail) return;
        int mid = head + (tail - head + 1) / 2;
        for(int i = head; i < mid; i++) {
            int tmp = nums[i];
            nums[i] = nums[tail - i + head];
            nums[tail - i + head] = tmp;
        }
    }

    public void exchange(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    public static void main(String[] args) {
        T31 t31 = new T31();

        int[] arr = {5,4,7,5,3,2};
//        t31.reverse(arr, 0, 2);
//        System.out.println(Arrays.toString(arr));
        t31.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

}
