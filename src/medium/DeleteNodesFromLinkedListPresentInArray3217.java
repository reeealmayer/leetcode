package medium;

import not_sorted.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.stream.Stream;

public class DeleteNodesFromLinkedListPresentInArray3217 {
    public static ListNode modifiedList(int[] nums, ListNode head) {
//        HashSet<Integer> numSet = new HashSet<>();
//        for (int num : nums) {
//            numSet.add(num);
//        }
//        ListNode prev = new ListNode(0);
//        ListNode newHead = prev;
//        while (head != null) {
//            if (!numSet.contains(head.val)) {
//                ListNode curr = new ListNode(head.val);
//                prev.next = curr;
//                prev = curr;
//            }
//            head = head.next;
//        }
//        return newHead.next;
        int max = Arrays.stream(nums).max().getAsInt();
        boolean[] freq = new boolean[max + 1];

        for (int num : nums) {
            freq[num] = true;
        }

        ListNode temp = new ListNode();
        ListNode curr = temp;
        while(head != null) {
            if ((head.val >= freq.length) || (freq[head.val] == false)) {
                curr.next = head;
                curr = curr.next;
            }
            head = head.next;
        }
        curr.next = null;
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode newHead = modifiedList(new int[]{2}, listNode1);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}
