package leetCode;

import java.util.PriorityQueue;

public class T239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
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

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.offer(1);
        queue.offer(2);
        queue.offer(2);
        queue.remove(2);
        System.out.println(queue.peek());
    }
}
