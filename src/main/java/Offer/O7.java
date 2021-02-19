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

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        for(int i = 0; i < in.length; i++) {
            if(in[i] == pre[0]) {
                addTreeNode(root, pre, 1, in, 0, i, true);
                addTreeNode(root, pre, i + 1, in, i + 1, in.length - i - 1, false);
                break;
            }
        }

        return root;

    }

    private void addTreeNode(TreeNode root, int[] pre, int preIdx,
                             int[] in, int inIdx, int len, boolean isLeft) {
        if(len <= 0) return;
        for(int i = inIdx; i <= inIdx + len; i++) {
            if(in[i] == pre[preIdx]) {
                TreeNode currNode = new TreeNode(pre[preIdx]);
                if(isLeft) {
                    root.left = currNode;
                }else{
                    root.right = currNode;
                }
                addTreeNode(currNode, pre, preIdx + 1, in, inIdx, i - inIdx, true);
                addTreeNode(currNode, pre, preIdx + i - inIdx + 1,
                        in, preIdx + i - inIdx + 1, len - (i - inIdx) - 1, false);
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};

        O7 o7 = new O7();
        TreeNode treeNode = o7.reConstructBinaryTree(pre, in);
        
        System.out.println(o7.reConstructBinaryTree(pre, in).val);
    }
}
