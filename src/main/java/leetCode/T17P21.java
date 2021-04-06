package leetCode;


import java.util.Deque;
import java.util.LinkedList;

public class T17P21 {

    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i : height) {
            if(stack.isEmpty()) {
                stack.addLast(i);
            }else{
                stack.addLast(Math.max(stack.peekLast(), i));
            }
        }

        int rst = 0;
        int rightMax = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            rst += Math.min(stack.pollLast(), rightMax) - height[i];
        }


        return rst;

    }
}
