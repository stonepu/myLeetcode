package leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class T347 {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Node> queue = new PriorityQueue<Node>((a, b)->b.times - a.times);
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry entry : map.entrySet()) {
            queue.offer(new Node((int)entry.getValue(), (int)entry.getKey()));
        }

        int[] rst = new int[k];
        for(int i = 0; i < k; i++) {
            rst[i] = queue.poll().val;
        }
        return rst;
    }

    public class Node{
        int times;
        int val;

        public Node(int t, int v) {
            this.times = t;
            this.val = v;
        }
    }
}
