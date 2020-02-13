package leetcode.Question_8;

/**
 * @Author: Liyong.liu
 * @Date: 2019/11/4 下午2:59
 */
class Solution {
    public int myAtoi(String str) {
        String str_withoutSpace;
        if (str == null || (str_withoutSpace = str.trim()).length() == 0)
            return 0;
        char[] str_c = str_withoutSpace.toCharArray();
        int sign = 0;
        int result = 0;
        if (str_c[0] == '-') {
            sign = -1;
            str_c = str.trim().substring(1).toCharArray();
        } else if (str_c[0] == '+') {
            sign = -1;
            str_c = str.trim().substring(1).toCharArray();
        } else
            sign = 1;
        for (int i = 0; i < str_c.length && str_c[i] >= '0' && str_c[i] <= '9'; i++) {
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && str_c[i] - '0' > 7))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            else
                result = result * 10 + (str_c[i] - '0');
        }
        return result * sign;
    }
}