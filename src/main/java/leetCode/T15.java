package leetCode;

import java.util.*;

public class T15 {
    //暴力解法，超时，优化后通过，但是还是耗时长
    public class Node{
        int num1;
        int num2;

        public Node(int num1, int num2) {
            this.num1 = num1;
            this.num2= num2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return (num1 == node.num1 &&
                    num2 == node.num2
                    ) ||
                    (num1 == node.num2 &&
                    num2 == node.num1) ;
        }


        @Override
        public int hashCode() {
            return 131 * (num1 + num2);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        LinkedList<List<Integer>> rst = new LinkedList();
        if(nums.length < 3) return rst;
        HashSet<Node> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                int numK = 0 - nums[i] - nums[j];
                if(map.containsKey(numK) && map.get(numK) > j) {
                    int min = Math.min(nums[i], Math.min(nums[j], numK));
                    int max = Math.max(nums[i], Math.max(nums[j], numK));
                    Node node = new Node(min, 0 - min - max);
                    if(set.contains(node)) continue;
                    set.add(node);
                    List<Integer> list = new LinkedList();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(numK);
                    rst.add(list);
                }

            }
        }
        return rst;
    }
}
