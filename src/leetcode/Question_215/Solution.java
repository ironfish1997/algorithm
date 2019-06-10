package leetcode.Question_215;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return find(nums, 0, nums.length - 1, nums.length - k);
    }

    private int find(int[] nums, int l, int r, int targetIndex) {
        int p = partition(nums, l, r);
        if (p == targetIndex) {
            return nums[p];
        } else if (p < targetIndex) {
            return find(nums, p + 1, r, targetIndex);
        } else {
            return find(nums, l, p - 1, targetIndex);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int i = l + 1, j = r;
        int element = nums[l];
        while (true) {
            while (i <= r && nums[i] < element) i++;
            while (j >= l + 1 && nums[j] > element) j--;
            if (i > j) break;
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(s.findKthLargest(arr, 2));
    }
}