package com.mohit.greeksofgreeks.stacks;

import java.util.Stack;

public class PrefixToPostfix {
    public static void main(String[] args) {
        PrefixToPostfix prefix = new PrefixToPostfix();
        System.out.println(prefix.convertPrefixToPostfix("*+AB-CD"));
    }

    public String convertPrefixToPostfix(String s) {
        if (s.length() == 0) {
            return s;
        }
        Stack<String> stack = new Stack<>();
        int i = s.length() - 1;
        while (i >= 0) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                String s1 = stack.pop();
                String s2 = stack.pop();
                stack.push(s1 + s2 + s.charAt(i));
            }
            i--;
        }
        StringBuilder sb = new StringBuilder();
        for (String s1 : stack) {
            sb.append(s1);
        }
        return sb.toString();
    }
}
