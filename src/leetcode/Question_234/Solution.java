package leetcode.Question_234;

import leetcode.common.LinkedList;
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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        cur = head;
        Stack<Integer> stack = new Stack<>();
        if (length % 2 == 0) {
            int middle = length / 2;
            for (int i = 0; i < middle; i++) {
                stack.push(cur.val);
                cur = cur.next;
            }
            for (int i = 0; i < middle; i++) {
                if (stack.pop() != cur.val) {
                    return false;
                }
                cur = cur.next;
            }
        } else {
            int middle = length / 2;
            for (int i = 0; i < middle; i++) {
                stack.push(cur.val);
                cur = cur.next;
            }
            cur = cur.next;
            for (int i = 0; i < middle; i++) {
                if (stack.pop() != cur.val) {
                    return false;
                }
                cur = cur.next;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] list = new int[]{1, 2};
        ListNode head = LinkedList.createListNode(list, list.length);
        boolean result = s.isPalindrome(head);
        System.out.println(result);
    }
}