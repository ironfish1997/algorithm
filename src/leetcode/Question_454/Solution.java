package leetcode.Question_454;

import java.util.HashMap;
import java.util.Map;

class Solution {
    //O(n^2)的解法
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        assert A.length == B.length;
        assert B.length == C.length;
        assert C.length == D.length;
        Map<Integer, Integer> countCD = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                if (countCD.containsKey(C[i] + D[j])) {
                    countCD.put(C[i] + D[j], countCD.get(C[i] + D[j]) + 1);
                } else {
                    countCD.put(C[i] + D[j], 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (countCD.containsKey(-A[i] - B[j])) {
                    res += countCD.get(-A[i] - B[j]);
                }
            }
        }
        return res;
    }
}