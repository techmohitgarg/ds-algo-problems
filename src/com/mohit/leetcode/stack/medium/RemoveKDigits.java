package com.mohit.leetcode.stack.medium;

import java.util.Stack;

public class RemoveKDigits {

    public static void main(String[] args) {
        System.out.println(new RemoveKDigits().removeKdigits("112", 1));
    }

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        if (num.length() == 1 && k == 1) {
            return "0";
        }
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) sb.append(c);

        while (sb.length() > 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        if (sb.length() == 0) sb.append(0);
        return sb.toString();
    }
}