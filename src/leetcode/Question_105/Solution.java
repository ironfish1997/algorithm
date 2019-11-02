package leetcode.Question_105;

import leetcode.common.TreeNode;

/**
 * @Author: Liyong.liu
 * @Date: 2019/11/2 下午3:58
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0)
            return null;
        return buildTree(preorder,inorder, 0, preorder.length, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int pre_start, int pre_end, int in_start, int in_end){
        if(in_end<=in_start)
            return null;
        TreeNode root = new TreeNode(preorder[pre_start]);
        int mid = 0;
        for( int i= in_start; i < in_end; i++)
            if(inorder[i]==preorder[pre_start]){
                mid = i-in_start;
                break;
            }
        root.left = buildTree(preorder, inorder, pre_start+1, pre_start + mid,in_start, in_start +mid);
        root.right = buildTree(preorder, inorder, pre_start + mid +1, pre_end, in_start +mid+1, in_end);
        return root;
    }
}
