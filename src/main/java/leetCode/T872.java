package leetCode;

import java.util.LinkedList;

public class T872 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> list1 = new LinkedList();
        LinkedList<Integer> list2 = new LinkedList();
        getLeafNode(root1, list1);
        getLeafNode(root2, list2);
        if (list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) return false;
        }
        return true;
    }

    public void getLeafNode(TreeNode root, LinkedList<Integer> list) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }

        getLeafNode(root.left, list);
        getLeafNode(root.right, list);
    }

    public static void main(String[] args) {
        T872 t872 = new T872();
        T872.TreeNode node = t872.new TreeNode();
    }
}
