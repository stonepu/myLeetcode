package Offer;

public class O6 {
    public int[] reversePrint(ListNode head) {
        if(head == null) return new int[0];
        ListNode curr = head;
        ListNode next = head.next;
        head.next = null;
        int size = 1;
        while(next != null) {
            ++size;
            head = next.next;
            next.next = curr;
            curr = next;
            next = head;
        }

        int[] rst = new int[size];
        for(int i = 0; i < size; i++) {
            rst[i] = curr.val;
            curr = curr.next;
        }
        return rst;

    }
}
