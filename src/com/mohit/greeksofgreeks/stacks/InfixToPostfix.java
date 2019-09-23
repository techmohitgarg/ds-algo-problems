package com.mohit.greeksofgreeks.stacks;

import java.util.Stack;

public class InfixToPostfix {

    public static void main(String[] args) {
        InfixToPostfix postfix = new InfixToPostfix();
        System.out.println(postfix.infixToPostFix("(A+B)*(C-D)"));
    }

    public String infixToPostFix(String s) {
        if (s.length() == 0) {
            return s;
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        int i = 0;
        while (i < ch.length) {
            if (ch[i] == ' ') {
                continue;
            }
            if (Character.isLetterOrDigit(ch[i])) {
                sb.append(ch[i]);
            } else if (ch[i] == '(') {
                stack.push(ch[i]);
            } else if (ch[i] == ')') {
                while (!stack.empty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                if (!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    new Throwable("Invalid expression");
                }
            } else {
                // if char is Operator
                while (!stack.empty() && getSign(ch[i]) <= getSign(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.push(ch[i]);
            }
            i++;
        }
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public int getSign(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

}
