package leetcode.Question_343;

/**
 * @Author liyong.liu
 * @Date 2019-10-29
 **/
class Solution {

    public int integerBreak(int n) {
        assert n >= 2;
        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 1; j <= i - 1; j++) {
                memo[i] = maxThree(memo[i], i * (i - j), i * memo[i - j]);
            }
        return memo[n];
    }

    private int maxThree(Integer a, Integer b, Integer c) {
        return Math.max(Math.max(a, b), c);
    }
}
