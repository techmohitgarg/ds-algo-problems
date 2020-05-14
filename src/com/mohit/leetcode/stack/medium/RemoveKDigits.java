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

   /* public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        if (num.length() == 0) return "0";
        if (k == 0) return num;
        if (num.length() == 1 && k > 0) return "0";
        int i = 1;
        StringBuilder sb = new StringBuilder(num);
        while (i < sb.length() && k > 0) {
            if (sb.charAt(i - 1) > sb.charAt(i)) {
                while (i > 0 && k > 0 && sb.length() > 1 && sb.charAt(i - 1) > sb.charAt(i)) {
                    sb.deleteCharAt(i - 1);
                    i--;
                    k--;
                }
            }
            i++;
        }

        while (k > 0 && sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString().length() == 0 ? "0" : sb.toString();
    }*/
}