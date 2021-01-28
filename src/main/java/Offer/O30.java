package Offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class O30 {
    class MinStack {
        Deque<Integer> stack;
        Deque<Integer> helper;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new ArrayDeque();
            helper = new ArrayDeque();
        }

        public void push(int x) {
            stack.addLast(x);
            if(helper.isEmpty()) {
                helper.addLast(x);
            }else{
                helper.addLast(Math.min(helper.peekLast(), x));
            }
        }

        public void pop() {
            stack.pollLast();
            helper.pollLast();
        }

        public int top() {
            return stack.peekLast();
        }

        public int min() {
            return helper.peekLast();
        }
    }
}
