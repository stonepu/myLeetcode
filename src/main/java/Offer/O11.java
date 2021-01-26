package Offer;

public class O11 {
    //二分法一定要注意边界
    public int minArray(int[] numbers) {
        if(numbers.length == 1 || numbers[0] < numbers[numbers.length - 1]) return numbers[0];
        int len = numbers.length;
        int left = 0, right = len - 1;
        int mid = left + (right - left) / 2;
        while(left < right) {
            if(numbers[mid] > numbers[right]) {
                left = mid + 1;
            }else if(numbers[mid] < numbers[right]){
                right = mid;
            }else{
                --right;
            }
            mid = left + (right - left) / 2;
        }
        return numbers[right];
    }

    public static void main(String[] args) {
        O11 o11 = new O11();
        int[] arr= {3, 1, 3, 3, 3};
        System.out.println(o11.minArray(arr));
    }
}
