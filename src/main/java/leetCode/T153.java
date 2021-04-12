package leetCode;

public class T153 {
    public int findMin(int[] nums) {
        if(nums.length == 1 || nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        }

        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[left]) {
                if(nums[mid] < nums[mid - 1]) {
                    return nums[mid];
                }
                right = mid - 1;
            }
            else if(nums[mid] >= nums[left]) {
                if(nums[mid] > nums[mid + 1]) {
                    return nums[mid + 1];
                }
                left = mid + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4};
        T153 t153 = new T153();
        System.out.println(t153.findMin(arr));
    }
}
