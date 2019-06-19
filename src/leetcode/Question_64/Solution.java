package leetcode.Question_64;

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1) {
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                } else if (i != grid.length - 1 && j == grid[0].length - 1) {
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                } else if (i != grid.length - 1 && j != grid[0].length - 1) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
                } else {
                    continue;
                }
            }
        }
        return grid[0][0];
    }
//    public int minPathSum(int[][] grid) {
//        if (grid == null) {
//            return 0;
//        }
//        return findPath(grid, 0, 0);
//    }
//    private int findPath(int[][] grid, int i, int j) {
//        if (i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
//        if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
//        return grid[i][j] + Math.min(findPath(grid, i + 1, j), findPath(grid, i, j + 1));
//    }
}