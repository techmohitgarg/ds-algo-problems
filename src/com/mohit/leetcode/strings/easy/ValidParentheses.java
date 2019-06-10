package com.mohit.leetcode.strings.easy;
/*
https://leetcode.com/problems/valid-parentheses/
 */
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses main = new ValidParentheses();
        System.out.println(main.isValid("(])"));
    }

    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char pev = stack.peek();
                if ((pev == '[' && c == ']') || (pev == '{' && c == '}') || pev == '(' && c == ')') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }


}
