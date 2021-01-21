package leetCode;

public class T124 {
    private int maxPath;
    public int maxPathSum(TreeNode root) {
        maxPath = Integer.MIN_VALUE;
        getMaxChileLen(root);
        return maxPath;
    }

    public int getMaxChileLen(TreeNode root) {
        if(root == null) return -1001;
        int leftCmpLen = getMaxChileLen(root.left);
        int rightCmpLen = getMaxChileLen(root.right);
        int currMaxLen = root.val;

        int leftLen = leftCmpLen < -1000 ? 0 : leftCmpLen;
        int rightLen = rightCmpLen < -1000 ? 0 : rightCmpLen;
        if(root.val >= 0) {
            currMaxLen = Math.max(root.val, Math.max(Math.max(leftLen + root.val, rightLen + root.val), rightLen + leftLen + root.val));
        }else{
            currMaxLen = Math.max(Math.max(Math.max(leftCmpLen, rightCmpLen), leftLen + rightLen + root.val), root.val);
        }

        maxPath = Math.max(maxPath, currMaxLen);
        return Math.max(Math.max(leftLen, rightLen) + root.val, root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(6);
        root.right = new TreeNode(-3);
        root.right.left = new TreeNode(-6);
        root.right.right = new TreeNode(2);
        root.right.right.left = new TreeNode(2);
        root.right.right.left.left = new TreeNode(-6);
        root.right.right.left.right = new TreeNode(-6);
        root.right.right.left.left.left = new TreeNode(-6);

        T124 t124 = new T124();
        System.out.println(t124.maxPathSum(root));
    }
}
