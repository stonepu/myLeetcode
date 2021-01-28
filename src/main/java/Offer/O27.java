package Offer;

import leetCode.TreeNode;

public class O27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return root;
        TreeNode mirrRoot = new TreeNode(root.val);
        mirrorTree(root, mirrRoot);
        return mirrRoot;
    }

    public void mirrorTree(TreeNode root, TreeNode mirrRoot) {
        if(root.left != null) {
            mirrRoot.right = new TreeNode(root.left.val);
            mirrorTree(root.left, mirrRoot.right);
        }

        if(root.right != null) {
            mirrRoot.left = new TreeNode(root.right.val);
            mirrorTree(root.right, mirrRoot.left);
        }
    }
}
