package leetcode.Question_25;

import leetcode.common.ListNode;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(-1);
        ListNode dummy_head = dummy;
        ListNode cur = head;
        while (true) {
            int count = 0;
            ListNode ori = cur;
            while (cur != null && count < k) {
                stack.push(cur);
                cur = cur.next;
                count++;
            }
            if (count != k) {
                dummy.next = ori;
                break;
            }
            while (!stack.isEmpty()) {
                dummy.next = stack.pop();
                dummy = dummy.next;
            }
        }
        return dummy_head.next;
    }
}