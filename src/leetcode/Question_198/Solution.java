package leetcode.Question_198;

/**
 * @Author: Liyong.liu
 * @Date: 2019/11/1 下午8:39
 */
class Solution {
    public int rob(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int length = num.length;
        int[] memo = new int[length+1];
        memo[0] = 0;
        memo[1] = num[0];
        for (int i = 2; i <= length; i++) {
            memo[i] = Math.max(memo[i - 2] + num[i-1], memo[i - 1]);
        }
        return memo[length];
    }
}