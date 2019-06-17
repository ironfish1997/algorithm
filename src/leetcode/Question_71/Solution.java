package leetcode.Question_71;

import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] sub_path = path.split("/");
        for (String s : sub_path) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (s.length() > 0 && !s.equals(".")) {
                stack.push(s);
            }
        }
        String[] res = new String[stack.size()];
        int i = stack.size() - 1;
        for (; i >= 0; i--) {
            res[i] = stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for (String s : res) {
            sb.append(s + "/");
        }
        if (sb.length() == 1) {
            return sb.toString();
        } else {
            return sb.substring(0, sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.simplifyPath("/a/../../b/../c//.//"));
    }
}