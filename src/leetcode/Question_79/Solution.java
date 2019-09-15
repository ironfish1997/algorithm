package leetcode.Question_79;

/**
 * @Author liyong.liu
 * @Date 2019-09-15
 * <p>
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 **/
class Solution {
    private int[][] steps = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private boolean[][] visited;
    private int m, n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        assert m > 0;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if (searchWord(board, word, 0, i, j)) return true;
        return false;
    }

    private boolean searchWord(char[][] board, String word, int index, int startx, int starty) {

        if (index == word.length() - 1) return board[startx][starty] == word.charAt(index);
        if (board[startx][starty] == word.charAt(index)) {
            visited[startx][starty] = true;
            //从[startx,starty]出发，向四个方向寻找
            for (int i = 0; i < 4; i++) {
                int newx = startx + steps[i][0];
                int newy = starty + steps[i][1];
                if (inArea(newx, newy) && !visited[newx][newy])
                    if (searchWord(board, word, index + 1, newx, newy)) return true;
            }
            visited[startx][starty] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
