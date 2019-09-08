package leetcode.Question_93;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author liyong.liu
 * @Date 2019-09-08
 * <p>
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 注：使用回溯法可解决
 **/
class Solution {
    private Integer length = 0;
    private String input;
    private List<String> res = new ArrayList<>();
    private LinkedList<String> segments = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        length = s.length();
        input = s;
        restoreIpAddress(-1, 3);
        return res;
    }

    private void restoreIpAddress(int preDotLocation, int dots) {
        int maxDotLoc = Math.min(preDotLocation + 4, length - 1);
        for (int curDocLocation = preDotLocation+1; curDocLocation < maxDotLoc; curDocLocation++) {
            String segment = input.substring(preDotLocation+1, curDocLocation + 1);
            System.out.println(String.format("pre: %d, cur: %d, segment: %s, total: %s", preDotLocation+1, curDocLocation+1, segment, input));
            if (isValid(segment)) {
                segments.add(segment);
                if (dots - 1 == 0) doRestore(input.substring(curDocLocation + 1, length));
                else restoreIpAddress(curDocLocation, dots - 1);
                segments.removeLast();
            }
        }
    }

    private boolean isValid(String segment) {
        int length = segment.length();
        if (length > 3) return false;
        return (segment.charAt(0) != '0') ? Integer.valueOf(segment) < 256 : length == 1;
    }

    private void doRestore(String segment) {
        segments.add(segment);
        if (isValid(segment)) res.add(String.join(".", segments));
        segments.removeLast();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> resList = solution.restoreIpAddresses("25525511135");
        for(String res:resList){
            System.out.println(res);
        }
    }
}