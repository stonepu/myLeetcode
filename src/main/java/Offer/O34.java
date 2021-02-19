package Offer;

import leetCode.TreeNode;

import java.util.*;

public class O34 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> rst = new LinkedList<>();
        if (root == null) return rst;
        List<Integer> list = new LinkedList<>();
        addPath(root, rst, list, 0, sum);
        return rst;
    }

    public void addPath(TreeNode root, List<List<Integer>> rst, List<Integer> list, int currSum, int sum) {
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (currSum + root.val == sum) rst.add(new LinkedList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        if(root.left != null) {
            addPath(root.left, rst, list, currSum + root.val, sum);
        }

        if(root.right != null) {
            addPath(root.right, rst, list, currSum + root.val, sum);
        }

        list.remove(list.size() - 1);
    }
}
