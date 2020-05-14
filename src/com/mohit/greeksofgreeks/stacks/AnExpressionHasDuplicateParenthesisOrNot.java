package com.mohit.greeksofgreeks.stacks;

import java.util.Stack;

public class AnExpressionHasDuplicateParenthesisOrNot {

    public static void main(String[] args) {
        AnExpressionHasDuplicateParenthesisOrNot sol = new AnExpressionHasDuplicateParenthesisOrNot();

        System.out.println(sol.isExpressionHasDuplicateParenthesis("((a+(b))+(c+d))"));
    }


    public boolean isExpressionHasDuplicateParenthesis(String exp) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < exp.length()) {
            char ch = exp.charAt(i);
            if (!Character.isSpaceChar(ch)) {
                if (ch != ')') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') return true;
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        stack.pop();
                    }
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                }
            }
            i++;
        }
        return false;
    }

}