package com.mohit.greeksofgreeks.stacks;

import java.util.Stack;

public class PerfixToInfix {

    public static void main(String[] args) {
        PerfixToInfix perfixToInfix = new PerfixToInfix();
        System.out.println(perfixToInfix.convertPerfixToInfix("*+AB-CD"));

    }

    public String convertPerfixToInfix(String s) {
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
                stack.push("(" + s1 + s.charAt(i) + s2 + ")");
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