package bd;

import Offer.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class t4 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        if (head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode root = null;
        ListNode lastTail = null, currTail = null;
        while(check(first, k)) {
            int index = 0;
            lastTail = currTail;
            currTail = first;
            currTail.next = null;
            while(index < k - 1){
                ListNode tmp = second.next;
                second.next = first;
                first = second;
                second = tmp;
                ++index;
            }
            if(root == null) root = first;
            else if(lastTail != null) lastTail.next = first;
            first = second;
            if(second == null) break;

            second = second.next;

        }

        if(root == null) return first;
        currTail.next = first;
        return root;
    }

    public boolean check(ListNode node, int k) {
        int checNum = 0;
        while(node != null) {
            ++checNum;
            if(checNum == k) return true;
            node = node.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        root.next.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next.next = new ListNode(7);
        root.next.next.next.next.next.next.next = new ListNode(8);
        root.next.next.next.next.next.next.next.next = new ListNode(9);
        root.next.next.next.next.next.next.next.next.next = new ListNode(10);


        t4 t4 = new t4();
        ListNode head = t4.reverseKGroup(root, 2);
        ListNode.printList(head);
    }
}
