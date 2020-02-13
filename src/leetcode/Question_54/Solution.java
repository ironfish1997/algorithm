package leetcode.Question_54;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Liyong.liu
 * @Date: 2019/11/16 下午4:17
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        int[][] steps = new int[][]{{0, 1, 0, -1}, {1, 0, -1, 0}};
        int step = 0, count = 0;
        int row = matrix.length, col = matrix[0].length;
        int[][] memo = new int[row][col];
        int x = 0, y = 0;
        int temX = 0;
        int temY = 0;
        while (count < row * col) {
            if (temX >= 0 && temX < row && temY >= 0 && temY < col && memo[temX][temY] == 0) {
                result.add(matrix[temX][temY]);
                memo[temX][temY] = 1;
                count++;
                x = temX;
                y = temY;
            } else {
                step = (step + 1) % 4;
            }
            temX = x + steps[0][step];
            temY = y + steps[1][step];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.spiralOrder(new int[][]{{1, 2, 3}, {6, 5, 4}}));
    }
}
