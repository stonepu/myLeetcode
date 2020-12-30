package leetCode;

import java.util.PriorityQueue;

public class T1046 {

    @FunctionalInterface
    public interface MathAdd{
        int add(int a, int b);
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < stones.length; i++) {
            queue.offer(-1 * stones[i]);
        }
        while(queue.size() >= 2) {
            int first = queue.poll();
            int second = queue.poll();
            if(first - second != 0) {
                queue.offer(first - second);
            }
        }

        if(queue.isEmpty()) return 0;
        return queue.poll() * -1;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);

        queue.offer(-3);
        queue.offer(-1);
        queue.offer(-5);

        MathAdd t = (int a, int b) -> a * b;
        System.out.println(t.add(4, 5));


        System.out.println(queue.poll());
    }

}
