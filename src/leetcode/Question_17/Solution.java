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
        if (digits == null || digits.trim().length() == 0) {
            return res;
        }
        char[] chars = digits.trim().toCharArray();
        combinations(chars, 0, "");
        return res;
    }

    private void combinations(char[] chars, int index, String s) {
        if (index == chars.length) {
            res.add(s);
            return;
        }
        char c = chars[index];
        if (c <= '1' || c > '9') {
            return;
        }
        char[] letters = letterMap.get(c - '0').toCharArray();
        for (int i = 0; i < letters.length; i++) {
            combinations(chars, index + 1, s + letters[i]);
        }
        return;
    }
}