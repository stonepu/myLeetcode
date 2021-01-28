package Offer;
import leetCode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class O26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        Deque<TreeNode> deque = new LinkedList();
        deque.addLast(A);
        while(!deque.isEmpty()) {
            TreeNode left = deque.pollFirst();
            if(left.left != null) {
                deque.addLast(left.left);
            }
            if(left.right != null) {
                deque.addLast(left.right);
            }

            if(checkIsSubStruc(left, B)) return true;
        }
        return false;
    }

    public boolean checkIsSubStruc(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return checkIsSubStruc(A.left, B.left) && checkIsSubStruc(A.right, B.right);
    }
}
