package leetCode;

public class inter0404 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if((leftDepth == 0 && rightDepth <= 1) || (leftDepth <= 1 && rightDepth == 0)) {
            return true;
        }
        if(Math.abs(leftDepth - rightDepth) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);

    }

    public int getDepth(TreeNode root) {
        if(root == null) return 0;
        int depth = 1;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        inter0404 it = new inter0404();
        System.out.println(it.isBalanced(root));
    }
}
