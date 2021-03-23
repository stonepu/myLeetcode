package Offer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 自定义排序规则
 */
public class O45 {
    public String minNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.valueOf(nums[i]).toString();
        }

        Arrays.sort(arr, (x, y) -> (x + y).compareTo(y + x));
//        HashMap<Integer, Node> map = new HashMap();
//        for(int i = 0; i < 10; i++) {
//            map.put(i, new Node(-1));
//        }
//
//        for(int num : nums) {
//            addNode(map.get(getHead(num)), num);
//        }

        StringBuffer strBuffer = new StringBuffer();
//        for(int i = 0; i < 10; i++) {
//            Node node = map.get(i);
//            while(node.next != null) {
//                strBuffer.append("" + node.next.val);
//                node = node.next;
//            }
//        }
        for(String str : arr) {
            strBuffer.append(str);
        }

        return strBuffer.toString();
    }

    private int getHead(int num) {
        if(num < 10) return num;
        String numStr = Integer.valueOf(num).toString();
        return num / (int)Math.pow(10, numStr.length() - 1);
    }

    private boolean compare(int num1, int num2) {
        String str1 = Integer.valueOf(num1).toString();
        String str2 = Integer.valueOf(num2).toString();
        return Integer.valueOf(str1 + str2) >= Integer.valueOf(str2 + str1);
    }

    private int getSubHead(int num) {
        if(num < 10) return num;
        String numStr = Integer.valueOf(num).toString();
        return getHead(num - num / (int)Math.pow(10, numStr.length() - 1) * (int)Math.pow(10, numStr.length() - 1));
    }

    private void addNode(Node head, int val) {

        while(head.next != null) {
            if(compare(head.next.val, val)){
                Node node = new Node(val);
                node.next = head.next;
                head.next = node;
                return;
            }
            head = head.next;
        }
        head.next = new Node(val);
    }

    class Node{
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        O45 o45 = new O45();
        int[] arr = {3544,3013,3061,468};
        System.out.println(o45.minNumber(arr));
    }
}
