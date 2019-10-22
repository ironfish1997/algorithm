package leetcode.Question_70;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author liyong.liu
 * @Date 2019-10-22
 **/
class Solution {
    private static Map<Integer, Integer> steps = new HashMap<>();

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (!steps.containsKey(n)) steps.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        return steps.get(n);
    }
}
