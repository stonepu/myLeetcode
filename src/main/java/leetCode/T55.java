package leetCode;

public class T55 {

    public boolean canJump(int[] nums) {
        if(nums.length <= 1) return true;
        int position = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(position >= nums.length - 1) return true;
            position = Math.max(position, i + nums[i]);
            if(i >= position) return false;
        }

        return true;

    }
}
