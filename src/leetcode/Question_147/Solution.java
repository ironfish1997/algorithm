package leetcode.Question_147;

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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode dummy_head = dummy;
        dummy.next = head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val > cur.next.val) {
                ListNode e = cur.next;
                cur.next = cur.next.next;
                ListNode headFirst = dummy;
                while (headFirst.next != null) {
                    if (e.val < headFirst.next.val) {
                        ListNode temp = headFirst.next;
                        headFirst.next = e;
                        e.next = temp;
                        break;
                    }
                    headFirst = headFirst.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy_head.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] linklist = new int[]{-1, 5, 3, 4, 0};
        ListNode node = LinkedList.createListNode(linklist, linklist.length);
        node = s.insertionSortList(node);
        LinkedList.printListNode(node);
    }
}