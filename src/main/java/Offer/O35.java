package Offer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 复制复杂链表
 */
public class O35 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head == null) return head;

        HashMap<Node, Node> map = new HashMap();
        Node currNode = head;
        while(currNode != null) {
            map.put(currNode, new Node(currNode.val));
            currNode = currNode.next;
        }

        currNode = head;
        while(currNode != null) {
            map.get(currNode).next = map.get(currNode.next);
            map.get(currNode).random = map.get(currNode.random);
            currNode = currNode.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {
        Object[] o1 = new Object[3];
        Object[] o2 = new Object[3];
        Object[] o3 = new Object[6];


    }

}
