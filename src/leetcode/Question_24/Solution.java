package leetcode.Question_24;

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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode node1;
        ListNode node2;
        ListNode next;
        while (p.next != null && p.next.next != null) {
            node1 = p.next;
            node2 = node1.next;
            next = node2.next;
            node2.next = node1;
            node1.next = next;
            p.next = node2;
            p = p.next.next;
        }
        return dummy.next;
    }
}