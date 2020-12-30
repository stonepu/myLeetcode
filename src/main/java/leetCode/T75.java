package leetCode;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.Deque;

public class T75 {

    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

    public void sortColors1(int[] nums) {
        Queue<Integer> one = new LinkedList<>();

        Queue<Integer> two = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 2) {
                two.offer(i);
            }else if(nums[i] == 1) {
                if(two.isEmpty()){
                    one.offer(i);
                }else{
                    Integer val = two.poll();
                    exchange(nums, i, val);
                    one.offer(val);
                    two.offer(i);
                }
            }else{
                if(two.isEmpty()) {
                    if(one.isEmpty()) continue;
                    else{
                        int val = one.poll();
                        exchange(nums, val, i);
                        one.offer(i);
                    }
                }else{
                    int t = two.poll();
                    exchange(nums, i, t);
                    two.offer(i);
                    if(one.isEmpty()) continue;
                    else{
                        int o = one.poll();
                        exchange(nums, t, o);
                        one.offer(t);
                    }
                }
            }
        }
    }

    public void exchange(int[] arr, int p, int q){
        int tmp = arr[p];
        arr[p] = arr[q];
        arr[q] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,0};
        T75 t75 = new T75();
        t75.sortColors1(arr);
        System.out.println(Arrays.toString(arr));
    }
}
