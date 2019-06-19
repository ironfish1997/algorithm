package leetcode.Question_437;

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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = findPath(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    //在以node为根节点的二叉树中，寻找包含node的路径，和为num，返回这样的路径个数
    private int findPath(TreeNode node, int num) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        if (node.val == num) {
            res += 1;
        }

        res += findPath(node.left, num - node.val);
        res += findPath(node.right, num - node.val);
        return res;
    }
}