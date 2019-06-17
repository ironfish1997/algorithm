package leetcode.Question_150;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> symbol = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (symbol.contains(token)) {
                Integer a = Integer.parseInt(stack.pop());
                Integer b = Integer.parseInt(stack.pop());
                stack.push(compute(a, b, token) + "");
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private int compute(int a, int b, String eval) {
        switch (eval) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }
}