package com.mohit.greeksofgreeks.stacks;

import java.util.Stack;

public class ExpressionEvaluation {

    public static void main(String[] args) {
        System.out.println(evaluate("100 * ( 2 + 12 ) / 14"));
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
        expression = expression.replace(" ", "");
        char[] ch = expression.toCharArray();
        for (char c : ch) {
            if (c == ' ') continue;

            if (Character.isDigit(c)) {
                // Adding Number
                num = 10 * num + (c - '0');
            } else if (c == '(') {
                // Open Bracket Start
                operator.push(c);
                //Push Number in the stack
                if (num != 0)
                    stack.push(num);

                // Reset the Num value
                num = 0;
            } else if (c == ')') {
                // Push Number before Perform operation
                stack.push(num);
                // Perform Last operation
                stack.push(performOperation(stack, operator));

                // Remove the Open Bracket
                if (!operator.isEmpty() && operator.peek() == '(')
                    operator.pop();

                // Reset the Num Value
                num = 0;
            } else {
                // Push Number before Perform operation
                if (num != 0)
                    stack.push(num);
                // Check if the operator stack leading greater operator than current operator
                while (!operator.isEmpty() &&
                        getOperaterValue(operator.peek()) >= getOperaterValue(c)) {
                    stack.push(performOperation(stack, operator));
                }
                operator.push(c);
                num = 0;
            }
        }
        // Check if the num has
        if (num != 0) {
            stack.push(num);
        }
        //Iterate Rest of the stack which contains Operator and Number values
        while (stack.size() > 1 && operator.size() > 0) {
            // Perform Operation and Push Result In Stack
            result = performOperation(stack, operator);
            stack.push(result);
        }
        // Pop the Last Calculate value
        result = stack.pop();
        // Return the Result
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
                if (a == 0 || b == 0) return 0;
                return a / b;
        }
        return 0;
    }

}

