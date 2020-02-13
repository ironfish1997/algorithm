package leetcode.Question_50;

/**
 * @Author: Liyong.liu
 * @Date: 2019/11/16 下午3:52
 */
class Solution {
//    public double myPow(double x, int n) {
//        if (n == 0) {
//            return 1.0;
//        }
//        if (n < 0) {
//            x = 1 / x;
//            n = -n;
//        }
//        double result = 1.0;
//        for (int i = 0; i < n; i++) {
//            result = result * x;
//        }
//        return result;
//    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        double half = myPow(x, n / 2);
        double rest = myPow(x, n % 2);
        return half * half * rest;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2, 20));
    }
}
