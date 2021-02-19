package bd;

import leetCode.TreeNode;

import java.util.ArrayList;

/**
 * 根节点到叶子节点和为指定值的所有路径
 */

public class NC8 {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // write code here
        ArrayList<ArrayList<Integer>> rst = new ArrayList<>();
        if (root == null) return rst;

        ArrayList<Integer> curr = new ArrayList<>();
//        curr.add(root.val);
        dfs(root, sum, 0, curr, rst);

        return rst;
    }

    public void dfs(TreeNode root, int target, int curr,
                    ArrayList<Integer> list, ArrayList<ArrayList<Integer>> rst) {
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (curr + root.val == target && !list.isEmpty()) {
                rst.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }


        if (root.left != null)
            dfs(root.left, target, curr + root.val, list, rst);
        if (root.right != null)
            dfs(root.right, target, curr + root.val, list, rst);

        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        NC8 nc8 = new NC8();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        ArrayList<ArrayList<Integer>> arrayLists = nc8.pathSum(root, 3);
        System.out.println(arrayLists);
    }
}
