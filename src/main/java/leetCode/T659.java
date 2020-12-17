package leetCode;

import java.util.ArrayList;
import java.util.Stack;

public class T659 {

    public boolean isPossible(int[] nums) {
        if(nums.length < 3) return false;
        ArrayList<Stack<Integer>> list = new ArrayList();
        for(int i = 0; i < nums.length; i ++) {
            push(nums[i], list);
        }
        return check(list);
    }

    public void push(int val, ArrayList<Stack<Integer>> list){
        if(addItem(val, list)) return;
        Stack<Integer> stack = new Stack();
        stack.push(val);
        list.add(stack);
    }

    //对于等于的情况，需要将数插入到相应的位置
    public boolean addItem(int val, ArrayList<Stack<Integer>> list) {
        for(int i = list.size() - 1; i >= 0; i--){
            Stack<Integer> stack = list.get(i);
            if(val - stack.peek() == 1){
                stack.push(val);
                return true;
            }
        }
        return false;
    }

    public boolean check(ArrayList<Stack<Integer>> list) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).size() < 3) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        T659 t659 = new T659();
        int[] arr = {1, 2 ,3 ,3, 4, 5};
        System.out.println(t659.isPossible(arr));
    }

}
