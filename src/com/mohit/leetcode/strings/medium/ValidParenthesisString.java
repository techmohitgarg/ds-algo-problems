/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.leetcode.strings.medium;

import java.util.Stack;

/**
 *
 * @author Mohit Garg
 */
public class ValidParenthesisString {

    public static void main(String[] args) {
        ValidParenthesisString problems = new ValidParenthesisString();
        System.out.println(problems.checkValidString("(**)"));
    }

    public boolean checkValidString(String s) {
        int n = s.length();
        if (n == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '*') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    if (stack.peek() == '*' || stack.peek() == '(') {
                        char temp = stack.pop();
                        if (temp == '(') {
                            continue;
                        }
                        if (!stack.isEmpty() && stack.peek() == '(') {
                            stack.pop();
                            stack.push(temp);
                        } else if (temp == '*') {

                        } else {
                            return false;
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
