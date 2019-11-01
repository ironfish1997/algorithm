package leetcode.Question_198;

/**
 * @Author: Liyong.liu
 * @Date: 2019/11/1 下午8:39
 */
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int[] memo = new int[nums.length];
        return findMaxAfterTwo(0, nums, memo);
    }

    private int findMaxAfterTwo(int i, int[] nums, int[] memo) {
        if (i >= nums.length)
            return 0;
        if (i == nums.length - 1)
            return nums[i];
        if (i == nums.length - 2)
            return Math.max(nums[i], nums[i + 1]);
        if (memo[i] != 0)
            return memo[i];
        int maxTwo = findMaxAfterTwo(i + 2, nums, memo);
        int maxThree = findMaxAfterTwo(i + 3, nums, memo);
        int maxFour = findMaxAfterTwo(i + 4, nums, memo);
        memo[i] = Math.max(nums[i] + Math.max(maxTwo, maxThree), nums[i + 1] + Math.max(maxThree, maxFour));
        return memo[i];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rob(new int[]{1, 2, 3, 1});
    }
}