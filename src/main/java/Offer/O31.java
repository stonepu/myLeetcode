package Offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class O31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int pushIdx = 0, popIdx = 0;
        while (pushIdx < pushed.length && popIdx < popped.length) {
            if (pushed[pushIdx] == popped[popIdx]) {
                ++pushIdx;
                ++popIdx;
            } else if (stack.isEmpty() || stack.peekLast() != popped[popIdx]) {
                stack.addLast(pushed[pushIdx++]);
            }
            while (!stack.isEmpty() && stack.peekLast() == popped[popIdx]) {
                popIdx++;
                stack.pollLast();
            }

        }

        return pushIdx == popIdx;
    }

    public static void main(String[] args) {
        O31 o31 = new O31();
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 2, 1};
        System.out.println(o31.validateStackSequences(push, pop));
    }
}
