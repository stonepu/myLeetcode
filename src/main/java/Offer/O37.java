package Offer;

import java.util.*;
import leetCode.TreeNode;

public class O37 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer rst = new StringBuffer();
        rst.append("[");

        if(root != null) {
            Deque<TreeNode> que = new LinkedList();
            que.addLast(root);
            while(!que.isEmpty()) {
                TreeNode currNode = que.pollFirst();
                if(currNode == null){
                    rst.append("null,");
                }else{
                    rst.append(currNode.val + ",");
                    que.addLast(currNode.left);
                    que.addLast(currNode.right);
                }
            }
            rst.deleteCharAt(rst.length() - 1);
        }

        rst.append("]");
        return rst.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] rData = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.valueOf(rData[0]));
        Deque<TreeNode> que = new ArrayDeque();
        que.addLast(root);
        for(int i = 1; i < rData.length; i+=2) {
            String item1 = rData[i];
            String item2 = rData[i+1];
            if(que.isEmpty()) break;
            TreeNode node = que.pollFirst();
            if(!item1.equals("null")) {
                node.left = new TreeNode(Integer.valueOf(item1));
                que.addLast(node.left);
            }

            if(!item2.equals("null")) {
                node.right = new TreeNode(Integer.valueOf(item2));
                que.addLast(node.right);
            }

        }


        return root;

    }
}
