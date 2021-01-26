package Offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class O9 {
    Deque<Integer> inStack;
    Deque<Integer> outStack;
    public O9() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        inStack.addLast(value);
    }

    public int deleteHead() {
        if(outStack.isEmpty()) {
            while (!inStack.isEmpty()){
                outStack.addLast(inStack.pollLast());
            }
        }
        return outStack.pollLast();
    }
}
