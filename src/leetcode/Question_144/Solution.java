package leetcode.Question_144;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public class Command {
        boolean go;
        TreeNode node;

        Command(boolean go, TreeNode node) {
            this.go = go;
            this.node = node;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Stack<Command> commands = new Stack<>();
        commands.add(new Command(true, root));
        while (!commands.isEmpty()) {
            if (!commands.peek().go) {
                ret.add(commands.pop().node.val);
            } else {
                TreeNode node = commands.pop().node;
                if (node.right != null) {
                    commands.push(new Command(true, node.right));
                }
                if (node.left != null) {
                    commands.push(new Command(true, node.left));
                }
                commands.push(new Command(false, node));
            }
        }
        return ret;
    }
}