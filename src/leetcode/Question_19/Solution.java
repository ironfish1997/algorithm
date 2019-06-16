package leetcode.Question_19;

import leetcode.common.LinkedList;
import leetcode.common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int count = 0;
        ListNode fast = dummy;
        ListNode slow = null;
        while (fast != null) {
            fast = fast.next;
            if (slow != null) {
                slow = slow.next;
            }
            if (count++ == n) {
                slow = dummy;
            }
        }
        if (slow != null && slow.next != null) {
            slow.next = slow.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] list = new int[]{1, 2, 3, 4, 5};
        ListNode node = LinkedList.createListNode(list, list.length);
        Solution s = new Solution();
        node = s.removeNthFromEnd(node, 2);
        LinkedList.printListNode(node);
    }
}