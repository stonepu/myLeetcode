package Offer;

import java.util.HashMap;

public class O22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        HashMap<Integer, ListNode> map = new HashMap();
        int index = 0;
        while(head != null) {
            map.put(index++, head);
            head = head.next;
        }
        return map.get(index - k);

    }
}
