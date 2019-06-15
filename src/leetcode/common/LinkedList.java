package leetcode.common;

/**
 * @Author liyong.liu
 * @Date 2019-06-13
 **/
public class LinkedList {
    public static ListNode createListNode(int[] arr, int n) {
        if (arr.length == 0 || n == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < n; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void printListNode(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.print("NULL");
    }
}
