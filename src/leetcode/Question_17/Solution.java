package leetcode.Question_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private List<String> res = new ArrayList<>();
    private static Map<Integer, String> letterMap = new HashMap<>();

    static {
        letterMap.put(2, "abc");
        letterMap.put(3, "def");
        letterMap.put(4, "ghi");
        letterMap.put(5, "jkl");
        letterMap.put(6, "mno");
        letterMap.put(7, "pqrs");
        letterMap.put(8, "tuv");
        letterMap.put(9, "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        combination(digits.toCharArray(), 0, "");
        return res;
    }

    private void combination(char[] digits, int index, String previewRes) {
        if (index == digits.length) {
            res.add(previewRes);
            return;
        }
        char[] floorRes = letterMap.get(digits[index] - '0').toCharArray();
        for (char i : floorRes) {
            combination(digits, index + 1, previewRes + i);
        }
    }
}