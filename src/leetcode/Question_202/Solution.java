package leetcode.Question_202;

/**
 * @Author liyong.liu
 * @Date 2019-06-10
 **/
class Solution {
    public boolean isHappy(int n) {
        int result = 0;
        String ns = n + "";
        for (int i = 0; i < ns.length(); i++) result += Math.pow(Integer.parseInt(ns.charAt(i) + ""), 2);
        if (result == 1) return true;
        else if (result == 2 || result == 3 || result == 4) {
            return false;
        }
        return isHappy(result);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isHappy(19));
    }
}