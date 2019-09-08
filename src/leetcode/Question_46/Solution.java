package leetcode.Question_46;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author liyong.liu
 * @Date 2019-09-08
 **/
public class Solution {
    private List<List<Integer>> resList = new ArrayList<>();
    private boolean[] isUsed;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return resList;
        if (nums.length == 1) {
            List<Integer> res = new ArrayList<>();
            res.add(nums[0]);
            resList.add(res);
            return resList;
        }
        isUsed = new boolean[nums.length];
        permute(nums, 0, new Stack<Integer>());
        return resList;
    }

    private void permute(int[] nums, int index, Stack<Integer> integers) {
        if (index == nums.length) {
            resList.add(new ArrayList<>(integers));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!isUsed[i]) {
                integers.push(nums[i]);
                isUsed[i] = true;
                permute(nums, index + 1, integers);
                integers.pop();
                isUsed[i] = false;
            }
        }
        return;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> results = solution.permute(new int[]{1, 2, 3});
        for (List<Integer> res : results) {
            System.out.println(res);
        }
    }

}
