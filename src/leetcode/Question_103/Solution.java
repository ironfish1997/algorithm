package leetcode.Question_103;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rtn = new ArrayList<List<Integer>>();
        if (root == null) {
            return rtn;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean level = true;
        while (!queue.isEmpty()) {
            int level_length = queue.size();
            LinkedList<Integer> level_arr = new LinkedList<>();
            rtn.add(level_arr);
            //从左往右
            for (int i = 0; i < level_length; i++) {
                TreeNode node = queue.poll();
                if (level) {
                    level_arr.add(node.val);
                } else {
                    level_arr.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            level = !level;
        }
        return rtn;
    }

    public static void main(String[] args) {

    }
}