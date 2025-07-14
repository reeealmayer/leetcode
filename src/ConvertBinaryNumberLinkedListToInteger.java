public class ConvertBinaryNumberLinkedListToInteger {
    public static int getDecimalValue(ListNode head) {
        StringBuilder tempo = new StringBuilder();
        while (head != null) {
            tempo.append(head.val);
            head = head.next;
        }

        return Integer.parseInt(tempo.toString(), 2);
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
