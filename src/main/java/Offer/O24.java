package Offer;

public class O24 {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode tmpH = head;
        ListNode next = tmpH.next;
        tmpH.next = null;
        while(next != null) {
            ListNode tmp = next.next;
            next.next = tmpH;
            tmpH = next;
            next = tmp;
        }
        return tmpH;

    }
}
