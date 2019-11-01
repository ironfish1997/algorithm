package leetcode.Question_118;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Liyong.liu
 * @Date: 2019/11/1 下午9:48
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0)
            return result;
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> lastRow;
            if (i == 0) {
                row.add(1);
                result.add(row);
                continue;
            } else
                lastRow = result.get(i - 1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(lastRow.get(j - 1) + lastRow.get(j));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }
}