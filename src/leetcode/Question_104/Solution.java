package leetcode.Question_104;

import leetcode.common.TreeNode;

/**
 * @Author: Liyong.liu
 * @Date: 2019/11/2 下午3:08
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}