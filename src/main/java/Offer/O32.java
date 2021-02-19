package Offer;

import java.util.Deque;
import java.util.*;
import leetCode.TreeNode;

public class O32 {
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> rst = new LinkedList();
        if(root == null) return rst;
        Deque<TreeNode> currLayer = new LinkedList();
        currLayer.addLast(root);
        while(!currLayer.isEmpty()){
            Deque<TreeNode> nextLayer = new LinkedList();
            List<Integer> list = new LinkedList();
            while(!currLayer.isEmpty()){
                TreeNode curr = currLayer.pollFirst();
                list.add(curr.val);
                if(curr.left != null) {
                    nextLayer.addLast(curr.left);
                }
                if(curr.right != null) {
                    nextLayer.addLast(curr.right);
                }
            }
            rst.add(list);
            currLayer = nextLayer;
        }
        return rst;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rst = new LinkedList();
        if(root == null) return rst;
        boolean reverse = false;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while(!queue.isEmpty()) {
            Deque<TreeNode> tmpQue = new ArrayDeque<>();
            List<Integer> list = new LinkedList<>();
            while(!queue.isEmpty()) {
                TreeNode currNode = reverse ? queue.pollLast() : queue.pollFirst();
                list.add(currNode.val);
                if(!reverse) {
                    if(currNode.left != null) {
                        tmpQue.addLast(currNode.left);
                    }

                    if(currNode.right != null) {
                        tmpQue.addLast(currNode.right);
                    }
                }else{
                    if(currNode.right != null) {
                        tmpQue.addFirst(currNode.right);
                    }

                    if(currNode.left != null) {
                        tmpQue.addFirst(currNode.left);
                    }
                }
            }
            reverse = !reverse;
            rst.add(list);
            queue = tmpQue;
        }

        return  rst;
    }

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        int[] array = list.stream().mapToInt(Integer::valueOf).toArray();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        O32 o32 = new O32();
        System.out.println(o32.levelOrder(root));
    }
}
