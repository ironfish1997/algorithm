package leetcode.Question_129;

import leetcode.common.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int result = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        calcu(root, 0);
        return result;
    }

    private void calcu(TreeNode root, int num) {
        int temp = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            result += temp;
            return;
        }
        if (root.left != null) {
            calcu(root.left, temp);
        }
        if (root.right != null) {
            calcu(root.right, temp);
        }
    }

}