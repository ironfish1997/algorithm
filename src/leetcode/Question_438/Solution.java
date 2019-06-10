package leetcode.Question_438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.trim().length() == 0) {
            return null;
        }
        int l = 0, r = -1;
        int[] pFreq = new int[26];
        int[] freq = new int[26];
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        //记录p中每个字母的频度
        for (char pcc : pc) {
            pFreq[pcc - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        while (l < sc.length) {
            if (r + 1 < sc.length && freq[sc[r + 1] - 'a'] < pFreq[sc[r + 1] - 'a']) freq[sc[++r] - 'a']++;
            else if (Arrays.equals(freq, pFreq)) {
                res.add(l);
                freq[sc[l++] - 'a']--;
            } else {
                freq[sc[l++] - 'a']--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findAnagrams("cbaebabacd", "abc"));
    }
}