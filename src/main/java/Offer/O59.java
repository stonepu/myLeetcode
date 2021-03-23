package Offer;

import java.util.*;

/**
 * 单调队列的使用，需要注意
 */
public class O59 {
    Deque<Integer> maxDeque;
    Deque<Integer> queue;

    public O59() {
        maxDeque = new ArrayDeque();
        queue = new ArrayDeque();
    }

    public int max_value() {
        if(queue.isEmpty()) return -1;
        return maxDeque.peekFirst();
    }

    public void push_back(int value) {
        queue.addLast(value);
        while(!maxDeque.isEmpty() && maxDeque.peekLast() < value) {
            maxDeque.pollLast();
        }

        maxDeque.addLast(value);
    }

    public int pop_front() {
        if(queue.isEmpty()) return -1;
        int rst = queue.pollFirst();
        if(maxDeque.peekFirst() == rst) maxDeque.pollFirst();
        return rst;
    }
}
