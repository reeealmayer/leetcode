package easy;

import not_sorted.ListNode;

public class LinkedListCycle141 {
    public boolean hasCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;

        while (first != null && first.next != null) {
            second = second.next;
            first = first.next.next;
            if (first == second) {
                return true;
            }
        }
        return false;
    }
}
