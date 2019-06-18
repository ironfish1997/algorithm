package leetcode.Question_23;

import leetcode.common.ListNode;

import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.compareTo(o2) > 0) {
                return 1;
            } else if (o1.compareTo(o2) < 0) {
                return -1;
            } else return 0;
        });
        for (ListNode node : lists) {
            while (node != null) {
                queue.offer(node.val);
                node = node.next;
            }
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode rtn = dummy;
        while (!queue.isEmpty()) {
            dummy.next = new ListNode(queue.poll());
            dummy = dummy.next;
        }
        return rtn.next;
    }
}