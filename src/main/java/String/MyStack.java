package String;

import java.util.LinkedList;

class MyStack {
    LinkedList<Integer> normal, reverse;

    /** Initialize your data structure here. */
    public MyStack() {
        normal = new LinkedList<Integer>();
        reverse = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        normal.offerLast(x);
        if(normal.isEmpty()) {
            reverse.offerLast(x);
        }else{
            LinkedList<Integer>temp = new LinkedList<>();
            temp.offerLast(x);
            while(!reverse.isEmpty()){
                System.out.println("pop");
                temp.offerLast(reverse.pop());
            }
            reverse = temp;
        }
        System.out.println(reverse.size() + " !");
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        System.out.println(reverse.size());
        int rst = reverse.pop();
        if(normal.size() == 1) {
            normal.pop();
            return rst;
        }
        LinkedList<Integer>temp = new LinkedList<>();
        for(int i = 0; i < reverse.size(); i++) {
            temp.offerLast(normal.pop());
        }
        normal = temp;
        return rst;

    }

    /** Get the top element. */
    public int top() {
        return reverse.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return normal.isEmpty();
    }

    public static void main(String[] args) {

         MyStack obj = new MyStack();
         obj.push(1);
         obj.push(2);
         obj.push(3);
         int param_2 = obj.pop();
         int param_3 = obj.pop();
         int param_1 = obj.pop();
         boolean param_4 = obj.empty();
    }
}