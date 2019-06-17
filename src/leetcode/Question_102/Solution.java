package leetcode.Question_102;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rtn = new ArrayList<List<Integer>>();
        if (root == null) {
            return rtn;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int level_size = queue.size();
            List<Integer> level_list = new ArrayList<>();
            rtn.add(level_list);
            for (int i = 0; i < level_size; i++) {
                TreeNode node = queue.poll();
                level_list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return rtn;
    }
}
