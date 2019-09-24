package com.mohit;

import java.util.HashMap;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(evaluate("10 + 2 * 6"));
    }

        /*
        "10 + 2 * 6"--->22
        "100 * 2 + 12"--->212
        "100 * ( 2 + 12 )"--->1400
        "100 * ( 2 + 12 ) / 14"--->100
        */

    public static int evaluate(String expression) {
        int result = 0;

        Stack<Character> operator = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char[] ch = expression.toCharArray();
        for (char c : ch) {
            if (c == ' ') continue;
            else if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            } else if (c == '(') {
                operator.push(c);
                stack.push(num);
                num = 0;
            } else if (c == ')') {
                stack.push(performOperation(stack, operator));
            } else {
                stack.push(num);
                while (!operator.isEmpty() && getOperaterValue(operator.peek()) >= getOperaterValue(c)) {
                    stack.push(performOperation(stack, operator));
                }
                operator.push(c);
                num = 0;
            }
        }
        result = performOperation(stack, operator);
        return result;
    }

    private static int getOperaterValue(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    private static int performOperation(Stack<Integer> stack, Stack<Character> operator) {
        if (stack.size() < 2 && operator.size() < 1) {
            return 0;
        }
        int b = stack.pop();
        int a = stack.pop();
        switch (operator.pop()) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }

}

