package com.mohit.leetcode.stack.easy;

import java.util.Stack;

public class RemoveOutermostParentheses {

    public static void main(String[] args) {
        System.out.println(new RemoveOutermostParentheses().removeOuterParentheses("(((((())))))"));
    }

    public String removeOuterParentheses(String S) {
        if (S == null || S.length() == 0) return S;
        StringBuilder res = new StringBuilder();
        int left = 1;
        int start = 0, end = 0;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == '(') left++;
            else left--;
            end = i;
            if (left == 0) {
                String cur = S.substring(start + 1, end);
                res.append(cur);
                start = end + 1;
            }
        }
        return res.toString();
    }

    public String removeOuterParentheses1(String S) {
        if (S.length() == 0) return S;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int last = -1;
        while (i < S.length()) {
            char c = S.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty() && last == 0) {
                    return "";
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    sb.append(S, last + 2, i);
                    last = i;
                }
            }
            i++;
        }
        if (!stack.isEmpty()) return "";
        return sb.toString();
    }
}
