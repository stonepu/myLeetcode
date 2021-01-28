package Offer;

public class O25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode rst;
        if(l1.val < l2.val){
            rst = l1;
            l1 = l1.next;
        }else{
            rst = l2;
            l2 = l2.next;
        }
        ListNode head = rst;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val){
                head.next = l1;
                l1 = l1.next;
            }else{
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }

        while(l1 != null) {
            head.next = l1;
            l1 = l1.next;
            head = head.next;
        }

        while(l2 != null) {
            head.next = l2;
            l2 = l2.next;
            head = head.next;
        }

        return rst;
    }
}
