package leetCode;

import java.util.Arrays;

public class T34 {

    //递归
    public int[] searchRange1(int[] nums, int target) {
        int low = searchLowBound(nums, target, 0, nums.length - 1);
        int high = searchHighBound(nums, target, 0, nums.length - 1);
        int[] out = {low, high};
        return out;
    }

    public int searchLowBound(int[] nums, int target, int low, int high) {
        if(low > high) return -1;

        int mid = low + (high - low) / 2;
        if(nums[mid] == target && (mid == 0 || nums[mid - 1] < target)) {
            return mid;
        }

        if(nums[mid] >= target) {
            return searchLowBound(nums, target, low, mid - 1);
        }else{
            return searchLowBound(nums, target, mid + 1, high);
        }
    }

    public int searchHighBound(int[] nums, int target, int low, int high) {
        if(low > high) return -1;

        int mid = low + (high - low) / 2;
        if(nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] > target)) {
            return mid;
        }

        if(nums[mid] > target) {
            return searchHighBound(nums, target, low, mid - 1);
        }else{
            return searchHighBound(nums, target, mid + 1, high);
        }
    }


    //迭代
    public int[] searchRange2(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int outL = -1, outH = -1;
        int[] out = {-1, -1};

        while(low <= high){
            int mid  = low + (high - low) / 2;
            if(nums[mid] == target && (mid == 0 || nums[mid - 1] < target)) {
                outL = mid;
                break;
            }

            if(nums[mid] >= target) {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        if(outL == -1){
            return out;
        }else{
            out[0] = outL;
        }

        low = 0;
        high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] > target)){
                outH = mid;
                break;
            }

            if(nums[mid] > target) {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        out[1] = outH;
        return out;
    }

    public static void main(String[] args) {
        int[] arr= {-1, -1};
        arr[0] = 1;
        System.out.println(Arrays.toString(arr));
    }
}
