package leetcode.Question_206;

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
    // public ListNode reverseList2(ListNode head) {
    //     if(head==null||head.next==null){
    //         return head;
    //     }
    //     ListNode p = reverseList(head.next);
    //     head.next.next = head;
    //     head.next = null;
    //     return p;
    // }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}