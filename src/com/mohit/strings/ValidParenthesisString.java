package com.mohit.strings;

import java.util.Stack;

public class ValidParenthesisString {

    public static void main(String[] args) {
        ValidParenthesisString problems = new ValidParenthesisString();
        System.out.println(problems.checkValidString("(((())))"));
    }

    public boolean checkValidString(String s) {
        int n = s.length();
        if (n == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '*') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                while (!stack.isEmpty()) {
                    if (stack.peek() == '*' || stack.peek() == '(') {
                        char temp = stack.pop();
                        if (temp == '(') {
                            break;
                        }
                        if (temp == '*' && !stack.isEmpty() && stack.peek() == '*') {
                            stack.pop();
                            continue;
                        }
                        if (!stack.isEmpty() && stack.peek() == '(') {
                            stack.pop();
                            //stack.push(temp);
                        } else if (stack.isEmpty() && (temp == '*' || temp == '(')) {
                            stack.push(temp);
                            break;
                        } else {
                            break;
                        }
                    }
                }

            }
        }

        while (!stack.isEmpty()) {
            if (stack.pop() == '(') {
                return false;
            }
        }

        return true;
    }
}