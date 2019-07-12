package leetcode.Question_279;

class Solution {
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        return findMinCompose(n);
    }

    //找到最小组合
    private int findMinCompose(int n) {
        if (n == 0) {
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "123";
        System.out.println(s.substring(0, 1));
    }
}