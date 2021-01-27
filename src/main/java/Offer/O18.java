package Offer;

public class O18 {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode tmp = head;
        while(tmp != null && tmp.next != null){
            if(tmp.next.val == val){
                tmp.next = tmp.next.next;
                break;
            }
            tmp = tmp.next;
        }
        return head;
    }
}
