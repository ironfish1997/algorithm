package leetcode.Question_290;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author liyong.liu
 * @Date 2019-06-10
 **/
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strArr = str.split(" ");
        if (strArr.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(strArr[i])) {
                    return false;
                }
            } else if (map.containsValue(strArr[i])) {
                return false;
            }
            map.put(pattern.charAt(i), strArr[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.wordPattern("abba", "dog dog dog dog"));
    }
}
