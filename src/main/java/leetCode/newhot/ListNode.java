package leetCode.newhot;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + "";
    }

    public static ListNode generateList(int[] arr) {
        ListNode head = new ListNode(-1);
        ListNode tmp = head;
        for (int i : arr) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }

        return head.next;
    }
}
