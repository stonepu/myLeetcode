package algrithm;

import leetCode.TreeNode;

import java.util.*;

public class TreeTest {

    public static int[] inOrder(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode last = root;
        stack.addLast(root);
//        list.add(root.val);   //前序遍历

        while (!stack.isEmpty()) {
            TreeNode top = stack.peekLast();
//            list.add(top.val);
            if (top.left != null && top.left != last && top.right != last) {
//                list.add(top.left.val);   //前序遍历
                stack.addLast(top.left);
            } else if (top.right != null && top.right != last && (top.left == null || top.left == last)) {
//                list.add(top.right.val);  //前序遍历
                list.add(top.val);    //中序遍历
                stack.addLast(top.right);
            } else {
//                list.add(top.val);    //后序遍历

                if (top.right == null) {  //中序遍历
                    list.add(top.val);
                }
                last = top;
                stack.pollLast();
            }
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(4);
//        root.left = new TreeNode(2);
////        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);
//        root.right = new TreeNode(6);
//        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(7);
//
//        System.out.println(Arrays.toString(inOrder(root)));

        int i = -1;
        i >>= 2;
        System.out.println(i);
    }
}
