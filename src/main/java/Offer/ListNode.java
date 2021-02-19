package Offer;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static void printList(ListNode node) {
        if(node == null) System.out.println("null");
        else{
            while(node != null) {
                System.out.printf("" + node.val + ", ");
                node = node.next;
            }
            System.out.println();
        }
    }
}
