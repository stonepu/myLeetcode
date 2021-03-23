package leetCode.newhot;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 时间复杂度O()，空间复杂度O()
 */
public class T2 {
    /**
     * 时间复杂度O(m + n)，空间复杂度O(max(m, n))
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }

        int next = 0;
        ListNode head = new ListNode(-1);
        ListNode tmp = head;

        while(l1 != null && l2 != null) {
            int val = l1.val + l2.val + next;
            next = val > 9 ? 1 : 0;
            tmp.next = new ListNode(val % 10);
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
      }

        while(l1 != null) {
            int val = l1.val + next;
            tmp.next = new ListNode(val % 10);
            next = val >= 10 ? 1 : 0;
            tmp = tmp.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            int val = l2.val + next;
            tmp.next = new ListNode(val % 10);
            next = val >= 10 ? 1 : 0;
            tmp = tmp.next;
            l2 = l2.next;
        }

        if(next == 1) {
            tmp.next = new ListNode(1);
        }

        return head.next;
    }
}
