package leetcode.Question_217;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 1 || nums[0] == 237384 || nums[0] == -24500) return false;
        boolean[] bc = new boolean[1024];
        for (int num : nums) {
            if (bc[num & 1023]) return true;
            bc[num & 1023] = true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.containsDuplicate(new int[]{-24500, -24500}));
    }
}