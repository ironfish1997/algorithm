package leetcode.Question_39;

import java.util.*;

/**
 * @Author liyong.liu
 * @Date 2019-09-14
 * <p>
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 **/
class Solution {
    private List<List<Integer>> rtn = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return rtn;
        }
        Arrays.sort(candidates);
        if (target < candidates[0]) {
            return rtn;
        }
        combinationSum(new LinkedList<Integer>(), candidates, target);
        return rtn;
    }

    private void combinationSum(LinkedList<Integer> oneRtn, int[] candidates, int left) {
        if (left == 0) {
            oneRtn.sort(Comparator.comparingInt(c -> c));
            rtn.add(new ArrayList<>(oneRtn));
            return;
        }
        for (int i = 0; i < candidates.length && candidates[i] <= left; i++) {
            if (oneRtn.size() == 0 || oneRtn.getLast() <= candidates[i]) {
                oneRtn.addLast(candidates[i]);
                combinationSum(oneRtn, candidates, left - candidates[i]);
                oneRtn.removeLast();
            }
        }
    }
}