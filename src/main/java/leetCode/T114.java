package leetCode;

public class T114 {
    public void flatten(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        addNode(root, root.right);
    }

    public void addNode(TreeNode root, TreeNode right) {
        if(root.left == null && right == null) return;
        if(root.left != null) {
            root.right = root.left;
            addNode(root.right, root.right.right);
        }else{
            root.right = null;
        }

        root.left = null;

        if(right != null) {
            while(root.right != null) {
                root = root.right;
            }
            root.right = right;
            addNode(root.right, right.right);
        }

    }

    public void printTreeNode(TreeNode root) {
        while(root != null) {
            System.out.println(root.val);
            root = root.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        T114 t114 = new T114();
        t114.flatten(root);
        t114.printTreeNode(root);
    }
}
