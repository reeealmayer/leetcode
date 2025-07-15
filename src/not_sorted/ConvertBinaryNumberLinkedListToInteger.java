package not_sorted;

public class ConvertBinaryNumberLinkedListToInteger {
    public static int getDecimalValue(ListNode head) {
        int result = 0;
        while (head != null) {
            result = (result << 1) | head.val;
            head = head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(0);
        ListNode listNode3 = new ListNode(1);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        System.out.println(getDecimalValue(listNode1));
    }
}
