package leetCode;

import java.util.LinkedList;
import java.util.List;

public class T102 {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rst = new LinkedList();
        if(root == null) return rst;
        List<TreeNode> last = new LinkedList();
        List<TreeNode> curr = new LinkedList();
        last.add(root);

        while(!last.isEmpty()) {
            List<Integer> list = new LinkedList();
            for(TreeNode node : last) {
                list.add(node.val);
                if(node.left != null) curr.add(node.left);
                if(node.right != null) curr.add(node.right);
            }

            last.clear();
            List<TreeNode> tmp = last;
            last = curr;
            curr = tmp;
            rst.add(list);
        }

        return rst;
    }
}
