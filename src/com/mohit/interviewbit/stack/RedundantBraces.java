package com.mohit.interviewbit.stack;

import java.util.Stack;

public class RedundantBraces {

    public static void main(String[] args) {
        String s = "(a+b)";
        System.out.println(new RedundantBraces().braces(s));
    }


    public int braces(String A) {
        Stack<Character> stack = new Stack<>();
        for (char c : A.toCharArray()) {
            // Push char in stack if ( or any operator
            if (c != ')') {
                stack.push(c);
            } else {
                // if stack is empty return false
                if (stack.isEmpty()) return 0;
                //if stack top value is "(" means redundant bracket
                if (stack.peek() == '(') return 1;
                int operator = 0;
                // Run while loop until open bracket open
                while (!stack.isEmpty() && stack.peek() != '(') {
                    if (stack.peek() == '+' || stack.peek() == '-'
                            || stack.peek() == '*' || stack.peek() == '/') {
                        operator = 1;
                    }
                    stack.pop();
                }
                if (operator == 0) return 1;
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }
        }

        return 0;
    }
    public boolean isStackHasRedundantBrackets(String str) {
        if (str.length() == 0) return false;
        int i = -1;
        Stack<Character> st = new Stack<>();
        while (i < str.length() - 1) {
            char ch = str.charAt(++i);
            if (ch == '(' || ch == '+' || ch == '-' || ch == '/' || ch == '*') {
                st.push(ch);
            } else if (ch == ')') {
                if (!st.isEmpty() && st.peek() == '(') return true;
                while (!st.isEmpty() && st.peek() != '(') {
                    st.pop();
                }
                if (!st.isEmpty() && st.peek() == '(')
                    st.pop();
            }
        }
        return false;
    }
}

