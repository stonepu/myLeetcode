package bd;

import java.util.Stack;

/**
 * 容器盛水
 */
public class NC128 {

    /**
     * max water
     * @param arr int整型一维数组 the array
     * @return long长整型
     */
    public long maxWater (int[] arr) {
        // write code here
        if(arr.length < 3) return 0;
        int[] idxArr = new int[arr.length];
        idxArr[0] = -1;
        int leftMaxIdx = 0;
        int rightMaxIdx = arr.length - 1;
        int capacity = 0;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[leftMaxIdx]) {
                capacity += (arr[i] - arr[leftMaxIdx]) * i;
                idxArr[i] = -1;
                leftMaxIdx = i;
            }else{
                capacity += arr[leftMaxIdx] - arr[i];
                idxArr[i] = leftMaxIdx;
            }
        }

        capacity -= arr[leftMaxIdx] - arr[arr.length - 1];
        for(int i = arr.length - 2; i >= 0; i--) {
            if(arr[i] >= arr[rightMaxIdx] || idxArr[i] == -1) {
                capacity -= arr[leftMaxIdx] - arr[i];
            }else{
                capacity -= Math.abs(arr[rightMaxIdx] - arr[idxArr[i]]);
            }
            if(arr[i] > arr[rightMaxIdx]){
                rightMaxIdx = i;
            }
        }
        return capacity;
    }

    public static void main(String[] args) {
        NC128 nc128 = new NC128();
        int[] arr = {3,1,2,5,2,4};
        System.out.println(nc128.maxWater(arr));
    }
}
