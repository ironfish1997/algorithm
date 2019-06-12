package leetcode.Question_49;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] sc = strs[i].toCharArray();
            Arrays.sort(sc);
            String s = new String(sc);
            if (!map.containsKey(s)) map.put(s, new ArrayList<String>());
            map.get(s).add(strs[i]);
        }
        return new ArrayList(map.values());
    }
}