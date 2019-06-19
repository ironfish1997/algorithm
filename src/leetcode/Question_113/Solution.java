package leetcode.Question_113;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<Integer> list = new LinkedList<>();
        pathSumList(root, sum, list);
        return res;
    }

    private void pathSumList(TreeNode node, Integer sum, LinkedList<Integer> rtn) {
        if (node == null) {
            return;
        }
        rtn.add(node.val);
        if (node.left == null && node.right == null && sum - node.val == 0) {
            res.add(rtn);
        }
        pathSumList(node.left, sum - node.val, rtn);
        pathSumList(node.right, sum - node.val, rtn);
    }
}