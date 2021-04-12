package leetCode;

public class T81 {
    public boolean search(int[] nums, int target) {


        return search(nums, 0, nums.length - 1, target);
    }

    public boolean search(int[] nums, int start, int end, int target) {
        if(start > end) {
            return false;
        }

        if(start == end) {
            return nums[start] == target;
        }

        int mid = start + (end - start) / 2;
        if(nums[mid] == target) {
            return true;
        }

        if(nums[start] == nums[end] && nums[start] == nums[mid]) {
            return search(nums, start + 1, end - 1, target);
        }
        else if(nums[mid] > target) {
            if(nums[start] < target) {
                return search(nums, start, mid - 1, target);
            }else{
                if(nums[mid] <= nums[start]) {
                    return search(nums, start, mid - 1, target);
                }else{
                    return search(nums, mid + 1, end, target);
                }
            }
        }else{
            if(nums[end] >= target) {
                return search(nums, mid + 1, end, target);
            }else {
                if(nums[mid] <= nums[end]) {
                    return search(nums, start, mid - 1, target);
                }else{
                    return search(nums, mid + 1, end, target);
                }
            }

        }
    }

    public static void main(String[] args) {
        T81 t81 = new T81();
        System.out.println(t81.search(new int[]{1, 0,1,1,1}, 0));
    }
}
