package leetCode;

public class T4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length == 0) {
            if(nums2.length % 2 == 1) {
                return nums2[nums2.length / 2];
            }else{
                return 1.0 * (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2;
            }
        }

        if(nums2.length == 0) {
            if(nums1.length % 2 == 1) {
                return nums1[nums1.length / 2];
            }else{
                return 1.0 * (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2;
            }
        }

        if(nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        int m = nums1.length;
        int n = nums2.length;

        int totalLeft = m + (n - m + 1) / 2;

        int left = 0;
        int right = m;
        while(left < right) {
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;
            if(nums1[i - 1] >nums2[j]) {
                right = i - 1;
            }else if(i == m || nums1[i] < nums2[j - 1]){
                left = i;
            }else{
                break;
            }
        }
        int i = left + (right - left + 1) / 2;
        System.out.println(i);
        int j = totalLeft - i;
        int left1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int right1 = i == m ? Integer.MAX_VALUE : nums1[i];
        int left2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int right2 = j == n ? Integer.MAX_VALUE : nums2[j];

        if((n + m ) % 2 == 1) {
            System.out.println("ou");
            return (double)Math.max(left1, left2);
        }else{
            return (double)(1.0 * (Math.max(left1, left2) + Math.min(right1, right2)) / 2);
        }
    }

    public static void main(String[] args) {
        T4 t4 = new T4();
        int[] arr1 = {1, 2 ,5};
        int[] arr2 = {3, 4 ,6};
        System.out.println(t4.findMedianSortedArrays(arr1, arr2));
    }
}
