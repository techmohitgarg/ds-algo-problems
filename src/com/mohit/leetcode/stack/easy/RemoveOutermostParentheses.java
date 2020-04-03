package com.mohit.leetcode.stack.easy;

import java.util.Stack;

public class RemoveOutermostParentheses {

    public static void main(String[] args) {
        System.out.println(new RemoveOutermostParentheses().removeOuterParentheses("(((((())))))"));
    }

    public String removeOuterParentheses(String S) {
        int len = S.length();
        // Base Case
        if (len == 0) return S;
        StringBuilder result = new StringBuilder();
        int close = 1;
        int open = 0;
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == '(') {
                if (open == 0) {
                    open += 1;
                } else {
                    open += 1;
                    result.append("(");
                }
            } else {
                if (close == open) {
                    close = 1;
                    open = 0;
                } else {
                    close += 1;
                    result.append(")");
                }
            }
        }
        return result.toString();
    }
    /*public String removeOuterParentheses(String S) {
        int len = S.length();
        // Base Case
        if (len == 0) return S;
        StringBuilder result = new StringBuilder();
        int start = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (count == 0) {
                start = i;
            }
            if (S.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                result.append(S, start + 1, i);
            }
        }
        return result.toString();
    }*/
    /*public String removeOuterParentheses(String S) {
        int len = S.length();
        // Base Case
        if (len == 0) return S;

        StringBuilder result = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int start = 0;
        for (int i = 0; i < len; i++) {
            if (st.isEmpty()) {
                start = i;
            }
            if (S.charAt(i) == '(') {
                st.push('(');
            } else {
                if (st.peek() == '(') {
                    st.pop();
                }
            }
            if (st.empty()) {
                result.append(S, start + 1, i);
            }
        }
        return result.toString();
    }*/
}
