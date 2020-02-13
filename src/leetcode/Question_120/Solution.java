package leetcode.Question_120;

public class Solution {
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int count = 0;
        int lastIndex = getLastKIndex(array, k, 0, array.length - 1);
        int firstIndex = getFirstKIndex(array, k, 0, array.length - 1);
        if (firstIndex > -1 && lastIndex > -1) {
            count = lastIndex - firstIndex + 1;
        }
        return count;
    }

    private int getFirstKIndex(int[] array, int k, int start, int end) {
        if (end < start) {
            return -1;
        }
        int middleIndex = (end - start) / 2 + start;
        int middleData = array[middleIndex];
        if (middleData == k) {
            if ((middleIndex > 0 && array[middleIndex - 1] != k) || middleIndex == 0) {
                return middleIndex;
            } else {
                end = middleIndex - 1;
            }
        } else if (middleData > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }
        return getFirstKIndex(array, k, start, end);
    }

    private int getLastKIndex(int[] array, int k, int start, int end) {
        if (end < start) {
            return -1;
        }
        int middleIndex = (end - start) / 2 + start;
        int middleData = array[middleIndex];
        if (middleData == k) {
            if ((middleIndex < array.length-2 && array[middleIndex + 1] != k) || middleIndex == array.length - 1) {
                return middleIndex;
            } else {
                start = middleIndex + 1;
            }
        } else if (middleData > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }
        return getLastKIndex(array, k, start, end);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.GetNumberOfK(new int[]{1, 2, 3, 3, 3, 3}, 3));
    }
}