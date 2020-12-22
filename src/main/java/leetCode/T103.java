package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class T103 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Deque<TreeNode> oddsStack = new ArrayDeque<>();
        Deque<TreeNode> evenStack = new ArrayDeque<>();
        List<List<Integer>> rst = new LinkedList<>();

        if(root == null){
            return rst;
        }
        evenStack.add(root);

        boolean isOdds = false;

        while(!oddsStack.isEmpty() || !evenStack.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            if(isOdds) {
                while(!oddsStack.isEmpty()) {
                    TreeNode node = oddsStack.pop();
                    list.add(node.val);
                    if(node.right != null) {
                        evenStack.push(node.right);
                    }

                    if(node.left != null) {
                        evenStack.push(node.left);
                    }
                }

            }else{
                while(!evenStack.isEmpty()) {
                    TreeNode node = evenStack.pop();
                    list.add(node.val);
                    if(node.left != null){
                        oddsStack.push(node.left);
                    }

                    if(node.right != null) {
                        oddsStack.push(node.right);
                    }
                }
            }

            isOdds = !isOdds;
            rst.add(list);
        }
        return rst;
    }
}
