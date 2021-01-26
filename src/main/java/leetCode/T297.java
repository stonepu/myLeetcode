package leetCode;

import java.util.Deque;
import java.util.LinkedList;

public class T297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "[]";
        Deque<TreeNode> queue = new LinkedList<>();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        queue.addLast(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if(node == null) {
                stringBuffer.append("null,");
            }else{
                stringBuffer.append(Integer.toString(node.val) + ",");
                queue.addLast(node.left);
                queue.addLast(node.right);
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append("]");

        return stringBuffer.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 2) return null;
        data = data.substring(1, data.length() - 1);
        String[] dataArr = data.split(",");
        int rootVal = Integer.valueOf(dataArr[0]);

        TreeNode root = new TreeNode(rootVal);

        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int index = 1;
        while(index < dataArr.length) {
            String leftChild = dataArr[index++];
            String rightChild = dataArr[index++];
            TreeNode tmp = queue.pollFirst();
            if(!leftChild.equals("null")) {
                tmp.left = new TreeNode(Integer.valueOf(leftChild));
                queue.addLast(tmp.left);
            }

            if(!rightChild.equals("null")) {
                tmp.right = new TreeNode(Integer.valueOf(rightChild));
                queue.addLast(tmp.right);
            }
        }
        return  root;
    }
}
