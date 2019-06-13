package leetcode.Question_149;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        // 搜索直线上最多的点数
        int max = 0;
        for (int i = 0; i < n; i++) {
            int same = 1;
            for (int j = i + 1; j < n; j++) {
                int cnt = 0;
                // cnt 表示除了 i 坐标点外，有多少个点在 i、j 坐标点构成的直线上
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) same++;
                else {
                    cnt++;
                    long xDiff = (long) (points[i][0] - points[j][0]);
                    long yDiff = (long) (points[i][1] - points[j][1]);
                    for (int k = j + 1; k < n; k++) {
                        if (xDiff * (points[i][1] - points[k][1]) == yDiff * (points[i][0] - points[k][0])) {
                            cnt++;
                        }
                    }
                }
                max = Math.max(cnt + same, max);
            }
        }
        return max;
    }
}