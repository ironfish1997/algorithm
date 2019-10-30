package leetcode.Question_18;

import java.util.*;

/**
 * @Author liyong.liu
 * @Date 2019-10-30
 **/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        int n;
        if ((n = nums.length) < 4) return results;
        Arrays.sort(nums);
        int one = 0, two = 1;
        while (one <= n - 3) {
            while (one < two && two <= n - 2) {
                Map<Integer, Integer> memo = new HashMap<>();
                int rest = target - (nums[one] + nums[two]);
                if (rest < nums[0] + nums[1]) {
                    one++;
                    two = one + 1;
                    continue;
                }
                if (rest > nums[n - 1] + nums[n - 2]) {
                    two++;
                    continue;
                }
                for (int i = two + 1; i < n; i++) {
                    int rest2 = rest - nums[i];
                    if (memo.containsKey(rest2)) {
                        List<Integer> result = new ArrayList<>();
                        result.add(nums[one]);
                        result.add(nums[two]);
                        result.add(nums[i]);
                        result.add(nums[memo.get(rest2)]);
                        if (results.contains(result)) continue;
                        results.add(result);
                    } else {
                        memo.put(nums[i], i);
                    }
                }
                two++;
            }
            one++;
            two = one + 1;
        }
        return results;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[]{-6, -6, -2, 8, 1, -3, 0, -4, -2, -4, 0, -5, -6, 6, 9, 3, 9, 0}, -14));
    }
}