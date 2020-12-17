package leetCode;

public class T33 {
    //二分+分情况讨论
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) return mid;

            if(nums[mid] < target) {
                if(nums[low] <= nums[mid]) {
                    low = mid + 1;
                }else{
                    if(nums[low] > target) low = mid + 1;
                    else if (nums[low] < target) high = mid - 1;
                    else return low;
                }
            }
            else{
                if(nums[low] > nums[mid]) {
                    high = mid - 1;
                }else {
                    if(nums[low] < target) high = mid - 1;
                    else if(nums[low] > target) low = mid + 1;
                    else return low;
                }
            }

        }
        return -1;
    }
}







