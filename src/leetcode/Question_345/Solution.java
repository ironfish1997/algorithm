package leetcode.Question_345;

class Solution {
    public String reverseVowels(String s) {
        char[] sc = s.toCharArray();
        int l = 0, r = sc.length - 1;
        while (l < r) {
            if (sc[l] != 'a' && sc[l] != 'e' && sc[l] != 'i' && sc[l] != 'o' && sc[l] != 'u' && sc[l] != 'A' && sc[l] != 'E' && sc[l] != 'I' && sc[l] != 'O' && sc[l] != 'U')
                l++;
            else if (sc[r] != 'a' && sc[r] != 'e' && sc[r] != 'i' && sc[r] != 'o' && sc[r] != 'u' && sc[r] != 'A' && sc[r] != 'E' && sc[r] != 'I' && sc[r] != 'O' && sc[r] != 'U')
                r--;
            else {
                swap(sc, l++, r--);
            }
        }
        return new String(sc);
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseVowels(".,"));
    }
}