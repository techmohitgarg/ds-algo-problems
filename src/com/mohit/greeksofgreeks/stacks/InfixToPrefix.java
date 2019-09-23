package com.mohit.greeksofgreeks.stacks;

import java.util.Stack;

public class InfixToPrefix {

    public static void main(String[] args) {
        System.out.println(new InfixToPrefix().infixToPrefix("A+B*C+D"));
        System.out.println(new InfixToPostfix().infixToPostFix("A+B*C+D"));
    }

    public String infixToPrefix(String s) {
        if (s.length() == 0) {
            return s;
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        int i = ch.length - 1;
        while (i >= 0) {
            if (ch[i] == ' ') {
                continue;
            }
            if (Character.isLetterOrDigit(ch[i])) {
                sb.append(ch[i]);
            } else if (ch[i] == ')') {
                stack.push(ch[i]);
            } else if (ch[i] == '(') {
                while (!stack.empty() && stack.peek() != ')') {
                    sb.append(stack.pop());
                }
                if (!stack.empty() && stack.peek() == ')') {
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
            i--;
        }
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();

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
