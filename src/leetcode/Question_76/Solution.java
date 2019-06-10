package leetcode.Question_76;

class Solution {
    public String minWindow(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] pChars = t.toCharArray();
        int[] pMap = new int[128];
        int i = 0, j = 0; // 考察窗口[i,j-1]
        int count = pChars.length;
        int minLen = s.length() + 1, l = 0, r = 0;
        for (char pChar : pChars)
            pMap[pChar]++;
        while (j < sChars.length) {
            //减小计数
            if (pMap[sChars[j]] > 0) count--;
            pMap[sChars[j]]--;
            j++;
            //计数为 0说明区间[i,j-1] 包含 p
            while (count == 0) {
                //求得一个解
                if (j - i < minLen) {
                    minLen = j - i;
                    l = i;
                    r = j;
                }
                pMap[sChars[i]]++;
                // 增加计数
                if (pMap[sChars[i]] > 0) count++;
                i++;
            }
        }
        return minLen == s.length() + 1 ? "" : s.substring(l, r);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minWindow("bba", "ab"));
    }
}