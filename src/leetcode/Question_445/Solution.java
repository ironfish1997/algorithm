package leetcode.Question_445;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode head = null;
        while (cur1 != null) {
            stack1.push(cur1.val);
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            stack2.push(cur2.val);
            cur2 = cur2.next;
        }
        int flag = 0;
        while (!stack1.empty() || !stack2.empty() || flag != 0) {
            int value = 0;
            if (!stack1.isEmpty()) value += stack1.pop();
            if (!stack2.isEmpty()) value += stack2.pop();
            value += flag;
            ListNode node = new ListNode(value % 10);
            flag = value / 10;
            node.next = head;
            head = node;
        }
        return head;
    }
}