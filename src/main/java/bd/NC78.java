package bd;

import Offer.ListNode;

/**
 * 反转链表
 */
public class NC78 {

    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode first = head;
        ListNode second = head.next;
        first.next = null;
        while(second != null) {
            ListNode tmp = second.next;
            second.next = first;
            first = second;
            second = tmp;
        }
        return first;
    }
}
