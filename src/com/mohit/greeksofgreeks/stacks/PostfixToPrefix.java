package com.mohit.greeksofgreeks.stacks;

import java.util.Stack;

public class PostfixToPrefix {
    public static void main(String[] args) {
        PostfixToPrefix prefix = new PostfixToPrefix();
        System.out.println(prefix.convertPostfixToPrefix("ABC*+D+"));
    }

    public String convertPostfixToPrefix(String s) {
        if (s.length() == 0) {
            return s;
        }
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                String s1 = stack.pop();
                String s2 = stack.pop();
                stack.push(s.charAt(i) + s2 + s1);
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (String s1 : stack) {
            sb.append(s1);
        }
        return sb.toString();
    }
}
