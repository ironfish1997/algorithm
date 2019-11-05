package leetcode.Question_22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: Liyong.liu
 * @Date: 2019/11/4 下午8:10
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0)
            return result;
        getBreak(result, "", 0, 0, n);
        return result;
    }

    private void getBreak(List<String> res, String cur, int open, int close, int num) {
        if (cur.length() == num * 2) {
            res.add(cur);
            return;
        }
        if (open < num)
            getBreak(res, cur + "(", open + 1, close, num);
        if (close < open)
            getBreak(res, cur + ")", open, close + 1, num);
    }

}