package com.mohit.leetcode.stack.medium;

import java.util.Stack;

public class MinimumAddtoMakeParenthesesValid {
    public static void main(String[] args) {
        System.out.println(new MinimumAddtoMakeParenthesesValid().minAddToMakeValid("())"));
    }

    public int minAddToMakeValid(String S) {
        char[] ch = S.toCharArray();
        int i = 0;
        int count = 0;
        int left = 0;
        while (i < ch.length) {
            if (ch[i] == '(') {
                left++;
            } else {
                if (left == 0) {
                    count++;
                } else if (left > 0) {
                    left--;
                }
            }
            i++;
        }
        // Add count of remaining un-match brackets
        count += left;

        return count;
    }

    public int minAddToMakeValid1(String S) {
        Stack<Character> stack = new Stack<>();
        char[] ch = S.toCharArray();
        int i = 0;
        int count = 0;
        while (i < ch.length) {
            if (ch[i] == '(') {
                stack.push(ch[i]);
            } else {
                if (stack.isEmpty()) {
                    count++;
                } else if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }
            i++;
        }
        // Add count of remaining un-match brackets
        count += stack.size();

        return count;
    }
}