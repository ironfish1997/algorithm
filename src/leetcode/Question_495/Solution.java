package leetcode.Question_495;

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0;
        if (timeSeries == null || timeSeries.length == 0 || duration == 0) {
            return sum;
        }
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] - timeSeries[i - 1] > duration) {
                sum += duration;
            } else {
                sum += timeSeries[i] - timeSeries[i - 1];
            }
        }
        return sum + duration;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] timeSeries = {1, 4};
        int duration = 2;
        int rtn = s.findPoisonedDuration(timeSeries, duration);
        System.out.println(rtn);
    }
}