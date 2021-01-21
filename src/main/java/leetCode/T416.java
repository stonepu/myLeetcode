package leetCode;

public class T416 {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int it : nums) {
            total += it;
        }
        if(total % 2 != 0) return false;

        return checkNum(nums, 0, total / 2, total / 2);
    }

    public boolean checkNum(int[] nums, int index, int target, int left) {
        if(left == 0) return true;
        if(index >= nums.length || left < 0) return false;
        for(int i = index; i < nums.length; i++) {
            if(checkNum(nums, i + 1, target, left - nums[i])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        T416 t416 = new T416();
        int[] arr = {1, 2, 5};
        System.out.println(t416.canPartition(arr));
    }
}
