package leetCode;

public class BinarySearchTest {

    public static int binarySearch(int[] nums, int target) {
        int len = nums.length;
        if(len == 0 || (target > nums[0] && target > nums[len - 1])) {
            return - 1;
        }

        int left = 0, right = len - 1;
        return binarySearch(nums, left, right, target);
    }

    public static int binarySearch(int[] nums, int left, int right, int target) {
        if(left > right) {
            return -1;
        }
        if(left == right) {
            return nums[left] == target ? left : -1;
        }

        int mid = left + (right - left) / 2;
        if(nums[mid] == target) {
            return mid;
        }// 中间值小于target时
        else if(nums[mid] < target) {
            int rst = -1;
            // 如果最左边大于target，则考虑左边部分
            if(nums[left] >= target && (rst = binarySearch(nums, left, mid - 1, target)) != -1) {
                return rst;
            }// 如果最右边大于target，则考虑右边部分
            else if(nums[right] >= target && (rst = binarySearch(nums, mid + 1, right, target)) != -1) {
                return rst;
            }else {
                return -1;
            }
        }// 中间值大于target
        else{
            int rst = -1;
            // 考虑中间值左边是否递增，如果有递增，则考虑左边递增区间
            if(mid > 0 && nums[mid - 1] < nums[mid] && (rst = binarySearch(nums, left, mid - 1, target)) != -1) {
                return rst;
            // 考虑中间值右边是否有递减，如果有递减则考虑递减区间
            }else if(nums[mid] > nums[mid + 1] && (rst = binarySearch(nums, mid + 1, right, target)) != -1) {
                return rst;
            }else {
                return -1;
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 3, 1, 2, 4, 6};
        System.out.println(binarySearch(arr, 1));
        System.out.println(binarySearch(arr, 5));
        System.out.println(binarySearch(arr, 10));
        System.out.println(binarySearch(arr, 6));
    }
}
