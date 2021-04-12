package leetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class T1049 {
    public int lastStoneWeightII(int[] stones) {

        if(stones.length == 1) {
            return stones[0];
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            queue.add(stone);
        }

        while(queue.size() >= 2) {
            int f = queue.poll();
            int s = queue.poll();
            if(f > s) {
                queue.add(f - s);
            }
        }

        return queue.isEmpty() ? 0 : queue.peek();
    }

    public static void main(String[] args) {
        T1049 t1049 = new T1049();
        int[] arr = {2,7,4,1,8,1};
        System.out.println(t1049.lastStoneWeightII(arr));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.add(2);
        queue.add(1);
        queue.add(3);
        System.out.println(queue.peek());
    }
}
