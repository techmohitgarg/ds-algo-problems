package com.mohit.leetcode.stack.medium;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

    public static void main(String[] args) {
        MinimumRemoveToMakeValidParentheses sol = new MinimumRemoveToMakeValidParentheses();
        System.out.println(sol.minRemoveToMakeValid("))(("));
    }


    public String minRemoveToMakeValid(String sb) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        StringBuilder s = new StringBuilder(sb);
        int[] index = new int[s.length()];
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    index[i] = -1;
                    s.setCharAt(i, '.');
                }
            }
            i++;
        }
        while (!stack.isEmpty()) {
            s.setCharAt(stack.pop(), '.');
        }
        sb = s.toString().replace(".", "");
        return sb;
    }

    /*public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int[] index = new int[s.length()];
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    index[i] = -1;
                }
            }
            i++;
        }
        while (!stack.isEmpty()) {
            index[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < index.length; j++) {
            if (index[j] == 0) {
                sb.append(s.charAt(j));
            }
        }
        return sb.toString();
    }*/
}