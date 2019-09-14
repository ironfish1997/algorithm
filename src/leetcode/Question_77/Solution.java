package leetcode.Question_77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author liyong.liu
 * @Date 2019-09-14
 * <p>
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 **/
class Solution {
    private List<List<Integer>> rtn = new ArrayList<>();
    private LinkedList<Integer> elements = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n) return rtn;
        combine(elements, n, 1, k);
        return rtn;
    }

    private void combine(LinkedList<Integer> elements, int n, int start, int k) {
        if (k==0) {
            List<Integer> temp = new ArrayList<>(elements);
            rtn.add(temp);
            return;
        }
        for (int i = start; i <= n-k+1; i++) {
            elements.addLast(i);
            combine(elements, n, i + 1, k-1);
            elements.removeLast();
        }
    }
}