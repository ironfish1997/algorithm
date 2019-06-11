package leetcode.Question_451;

import java.util.Arrays;

/**
 * @Author liyong.liu
 * @Date 2019-06-11
 **/
class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int[] freq = new int[256];
        //记录每个字符出现的频率
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        int[] freqCopy = Arrays.copyOf(freq, freq.length);
        sort(freq, 0, freq.length - 1);
        StringBuilder res = new StringBuilder();
        for (int i = freq.length - 1; i >= 0 && freq[i] > 0; i--) {
            for (int j = 0; j < freqCopy.length; j++) {
                if (freqCopy[j] == freq[i]) {
                    while (freqCopy[j]-- > 0) {
                        res.append((char) j);
                    }
                }
            }
        }
        return res.toString();
    }

    private void sort(int[] arr, int l, int r) {
        if (l >= r) return;
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private int partition(int[] arr, int l, int r) {
        int element = arr[l];
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && arr[i] < element) i++;
            while (j >= l + 1 && arr[j] > element) j--;
            if (j < i) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, j, l);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.frequencySort("tree"));
    }
}