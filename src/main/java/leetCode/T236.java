package leetCode;

import java.util.LinkedList;
import java.util.List;

public class T236 {
    private boolean findOne, findAll;
    private TreeNode rst;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        rst = root;
        dfs(root, p, q);
        return rst;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(findAll) return true;
        if(root == null) return false;
        boolean out = false;
        if(root.val == p.val || root.val == q.val){
            out = true;
            if(findOne){
                findAll = true;
                return true;
            }else{
                findOne = true;
            }

        }
        if(out && !findAll) rst = root;
        out |= dfs(root.left, p, q) ;

//        if(findAll) return true;
        if(out && !findAll) rst = root;
        out |= dfs(root.right, p, q);
        return out;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(-2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(8);

        T236 t236 = new T236();
        System.out.println(t236.lowestCommonAncestor(root, root.left, root.left.left.left).val);
        LinkedList<Integer> integers = new LinkedList<>();
        integers.peek();
    }
}
