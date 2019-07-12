package leetcode.Question_98;

import leetcode.common.TreeNode;

/**
 * @Description 中序遍历
 * <br>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private Integer last = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            boolean isLeftValid = isValidBST(root.left);
            if (!isLeftValid) {
                return false;
            }
        }
        if (last != null && last >= root.val) {
            return false;
        }
        last = root.val;
        if (root.right != null) {
            return isValidBST(root.right);
        }
        return true;
    }
}