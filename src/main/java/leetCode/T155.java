package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class T155 {
    Deque<Integer> deq;
    PriorityQueue<Integer> que;
    /** initialize your data structure here. */
    public T155() {
        deq = new ArrayDeque();
        que = new PriorityQueue<>((a,b)->a-b);
    }

    public void push(int x) {
        deq.push(x);
        que.offer(x);
    }

    public void pop() {
        int rst = deq.pop();
        que.remove(rst);
    }

    public int top() {
        return deq.peek();
    }

    public int getMin() {
        return que.peek();
    }

    public static void main(String[] args) {
        T155 t155 = new T155();
        t155.push(-144);
        t155.push(145);
        System.out.println(t155.top());


        System.out.println(t155.getMin());
        System.out.println(t155.getMin());
        t155.push(-2147483648);
        t155.push(2147483647);
        t155.top();
        System.out.println(t155.getMin());
        System.out.println(t155.getMin());
    }
}
