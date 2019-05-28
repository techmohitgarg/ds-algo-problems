package com.mohit.stacks;

import java.util.Stack;

public class PostfixToInfix {

    public static void main(String[] args) {
        PostfixToInfix postfix = new PostfixToInfix();
        System.out.println(postfix.postfixToInfix("ab*c+"));
    }

    public String postfixToInfix(String s) {
        if (s.length() == 0) {
            return s;
        }
        Stack<String> stack = new Stack<>();
        char[] ch = s.toCharArray();
        int i = 0;
        while (i < ch.length) {
            if (Character.isLetterOrDigit(ch[i])) {
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                String s1 = stack.pop();
                String s2 = stack.pop();
                stack.push("(" + s2 + s.charAt(i) + s1 + ")");
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
