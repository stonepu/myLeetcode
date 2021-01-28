package Offer;

public class O21 {
    public int[] exchange(int[] nums) {
        int[] arr = new int[nums.length];
        int left = 0, right = nums.length - 1;
        while(right >= 0 && nums[right] % 2 == 0){
            --right;
        }
        while(left < right) {
            if(nums[left++] % 2 == 0) {
                swap(nums, left - 1, right);
                while(right > left && nums[right] % 2 == 0){
                    --right;
                }
            }
        }
        return nums;

    }

    public void swap(int[] nums, int m, int n){
        int tmp = nums[m];
        nums[m] = nums[n];
        nums[n] = tmp;
    }
}
