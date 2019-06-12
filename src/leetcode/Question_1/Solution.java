package leetcode.Question_1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int restTarget = target - nums[i];
            if (map.containsKey(restTarget)) {
                return new int[]{i, map.get(restTarget)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("Error");
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] res = s.twoSum(new int[]{1, 2, 3, 4, 5}, 6);
        for (int i : res) {
            System.out.print(i + ", ");
        }
    }
}