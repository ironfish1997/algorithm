package leetcode.Question_21;

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode rtn = new ListNode(-1);
        ListNode dummy = rtn;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                rtn.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                rtn.next = l1;
                l1 = l1.next;
            } else {
                if (l1.val < l2.val) {
                    rtn.next = l1;
                    l1 = l1.next;
                } else if (l1.val > l2.val) {
                    rtn.next = l2;
                    l2 = l2.next;
                } else {
                    rtn.next = l1;
                    l1 = l1.next;
                    rtn = rtn.next;
                    rtn.next = l2;
                    l2 = l2.next;
                }
            }
            rtn = rtn.next;
        }
        return dummy.next;
    }
}