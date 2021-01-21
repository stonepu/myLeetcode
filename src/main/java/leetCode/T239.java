package leetCode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class T239 {
    //超时
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] rst = new int[nums.length - k + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        rst[0] = queue.peek();
        for (int i = k; i < nums.length; i++) {
            queue.offer(nums[i]);
            queue.remove(nums[i - k]);

//            if(nums[i - k] == queue.peek()) {
//                queue.poll();
                rst[i - k + 1] = queue.peek();
//            }
        }

        return rst;
    }

    //超时，当输入数组为单调递减时，时间复杂度为O(nk)
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] rst = new int[nums.length - k + 1];
        int max = nums[0];
        for(int i = 0; i < k; i++) {
            max = Math.max(max, nums[i]);
        }
        rst[0] = max;
        for(int i = k; i < nums.length; i++) {
            if(nums[k] >= max) {
                max = nums[k];
                rst[i - k + 1] = max;
            }else{
                if(nums[i - k] < max) {
                    rst[i - k + 1] = max;
                }else{
                    max = nums[i - k + 1];
                    int index = i - k + 1;
                    while(index <= i) {
                        max = Math.max(max, nums[index]);
                        ++index;
                    }
                    rst[i - k + 1] = max;
                }
            }
        }
        return rst;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] rst = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++) {
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.addLast(i);

            while(!deque.isEmpty() && deque.peekFirst() < i - k + 1){
                deque.pollFirst();
            }
            if(i >= k - 1) {
                rst[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return rst;
    }

    public static void main(String[] args) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
//        queue.offer(1);
//        queue.offer(2);
//        queue.offer(2);
//        queue.remove(2);
//        System.out.println(queue.peek());

        T239 t239 = new T239();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(t239.maxSlidingWindow(nums, 3)));

    }
}
