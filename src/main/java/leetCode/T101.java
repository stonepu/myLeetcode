package leetCode;

import java.util.Deque;
import java.util.LinkedList;

public class T101 {

    public boolean isSymmetric(TreeNode root) {
        // return check(root, root);

        if (root == null) return true;
        Deque<TreeNode> left = new LinkedList();
        Deque<TreeNode> right = new LinkedList();
        left.add(root.left);
        right.add(root.right);
        while (!left.isEmpty() && !right.isEmpty()) {
            TreeNode first = left.poll();
            TreeNode second = right.poll();
            if (first == null && second == null) continue;
            if (first == null || second == null) return false;
            if (first.val != second.val) return false;

            left.add(first.left);
            left.add(first.right);
            right.add(second.right);
            right.add(second.left);
        }

        if (!left.isEmpty() || !right.isEmpty()) return false;
        return true;
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;

        if (left == null || right == null) return false;

        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }
}
