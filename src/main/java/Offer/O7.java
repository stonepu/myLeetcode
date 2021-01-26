package Offer;

import leetCode.TreeNode;

public class O7 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        int index = 0;
        while(inorder[index] != preorder[0]) ++index;
        TreeNode root = new TreeNode(preorder[0]);
        buildTree(root, preorder, 1, inorder, 0, index, true);
        buildTree(root, preorder, 1 + index, inorder, index + 1, preorder.length - index - 1, false);
        return root;
    }

    public void buildTree(TreeNode root, int[] preorder, int preIdx, int[] inorder, int inIdx, int len, boolean isLeft){
        if(len <= 0) return;
        if(isLeft) {
            root.left = new TreeNode(preorder[preIdx]);
            root = root.left;
        }else{
            root.right = new TreeNode(preorder[preIdx]);
            root = root.right;
        }
        if(len == 1) return;
        int index = 0;
        while(inorder[inIdx + index] != preorder[preIdx] && index < len){
            ++index;
        }
        buildTree(root, preorder, preIdx + 1, inorder, inIdx, index, true);
        buildTree(root, preorder, preIdx + index + 1, inorder, inIdx + index + 1, len - index - 1, false);
    }

    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};

        O7 o7 = new O7();
        System.out.println(o7.buildTree(pre, in).val);
    }
}
