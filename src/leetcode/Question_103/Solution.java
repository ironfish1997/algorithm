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
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        zigzagRecursive(0, root, result);
        return result;
    }

    private void zigzagRecursive(int level, TreeNode root, List<List<Integer>> result){
        if(root==null)
            return;
        LinkedList<Integer> row;
        if(result.size()<=level){
            row = new LinkedList<>();
            result.add(level,row);
        }else
            row = (LinkedList)result.get(level);

        if(level%2==0){
            row.add(root.val);
        }else{
            row.addFirst(root.val);
        }
        zigzagRecursive(level+1, root.left,result);
        zigzagRecursive(level+1, root.right,result);
    }
}