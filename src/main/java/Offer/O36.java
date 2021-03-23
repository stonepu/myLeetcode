package Offer;

/**
 * 二叉搜索树转双向链表
 */
public class O36 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        Node head = root, tail = root;
        Node[] rst = getChildNode(root);
        if(rst.length == 1) {
            rst[0].right = rst[0];
            rst[0].left = rst[0];
            return rst[0];
        }
        for(int i = 1; i < rst.length - 1; i++) {
            rst[i].right = rst[i + 1];
            rst[i].left = rst[i - 1];
        }
        rst[0].right = rst[1];
        rst[0].left = rst[rst.length - 1];
        rst[rst.length - 1].left = rst[rst.length - 2];
        rst[rst.length - 1].right = rst[0];
        return rst[0];
    }

    public Node[] getChildNode(Node root) {
        if(root == null) return new Node[]{};
        Node[] left = getChildNode(root.left);
        Node[] right = getChildNode(root.right);
        Node[] rst = new Node[left.length + right.length + 1];
        for(int i = 0; i < left.length; i++) {
            rst[i] = left[i];
        }
        rst[left.length] = root;

        for(int i = 0; i < right.length; i++) {
            rst[i + left.length + 1] = right[i];
        }

        return rst;
    }

    public static void main(String[] args) {
        String str = "1";
        str.substring(0, 1);
    }
}
