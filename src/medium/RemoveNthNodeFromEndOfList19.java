package medium;

import not_sorted.ListNode;

public class RemoveNthNodeFromEndOfList19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 0; i <= n; i++) {
            if (first != null) {
                first = first.next;
            }
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        node1.next = node2;
//        ListNode node3 = new ListNode(3);
//        node2.next = node3;
//        ListNode node4 = new ListNode(4);
//        node3.next = node4;
//        ListNode node5 = new ListNode(5);
//        node4.next = node5;

        removeNthFromEnd(node1, 1);
    }
}
