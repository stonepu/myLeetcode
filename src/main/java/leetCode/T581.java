package leetCode;

public class T581 {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if(len <= 1) return 0;
        int firstDown = -1, lastDown = -1, lastDownMax = -100001, firstDownMin = 100001;
        for(int i = 1; i < len; i++) {
            if(nums[i] < nums[i - 1]) {
                lastDown = i;
                lastDownMax = Math.max(lastDownMax, nums[i - 1]);
                firstDownMin = Math.min(firstDownMin, nums[i]);
                if(firstDown == -1) {
                    firstDown = i;
                }
            }
            else{
                if(nums[i] < lastDownMax) {
                    lastDown = i;
                }
            }
        }

        if(firstDown > -1) {
            for(int i = 0; i < len; i++) {
                if(nums[i] > firstDownMin) {
                    firstDown = i;
                    break;
                }
            }
        }
        if(lastDown == firstDown) return 0;
        return lastDown - firstDown + 1;
    }

    public static void main(String[] args) {
        T581 t581 = new T581();
        int[] nums = {2, 3, 3, 2, 4};
        int[] nums1 = {1, 3, 5, 4, 2};
        System.out.println(t581.findUnsortedSubarray(nums));
        System.out.println(t581.findUnsortedSubarray(nums1));

        String str = Integer.toString(2);
        System.out.println(str);
    }
}
