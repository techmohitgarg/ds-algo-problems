package com.mohit.stacks.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        EvaluateReversePolishNotation notation = new EvaluateReversePolishNotation();
        System.out.println(notation.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String val = tokens[i];
            if (val.length() <= 1 && isOperator(val)) {
                switch (val) {
                    case "+":
                        if (!stack.empty()) {
                            int val1 = stack.pop();
                            int val2 = stack.pop();
                            stack.push(val2 + val1);
                        }
                        break;
                    case "-":
                        if (!stack.empty()) {
                            int val1 = stack.pop();
                            int val2 = stack.pop();
                            stack.push(val2 - val1);
                        }
                        break;
                    case "*":
                        if (!stack.empty()) {
                            int val1 = stack.pop();
                            int val2 = stack.pop();
                            stack.push(val2 * val1);
                        }
                        break;
                    case "/":
                        if (!stack.empty()) {
                            int val1 = stack.pop();
                            int val2 = stack.pop();
                            stack.push(val2 / val1);
                        }
                        break;
                }
            } else {
                stack.push(Integer.parseInt(val));
            }
        }
        return stack.isEmpty() ? 0 : stack.pop();
    }

    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.size(); i++) {
            String val = A.get(i);
            if (val.length() <= 1 && isOperator(val)) {
                switch (val) {
                    case "+":
                        if (!stack.empty()) {
                            int val1 = stack.pop();
                            int val2 = stack.pop();
                            stack.push(val2 + val1);
                        }
                        break;
                    case "-":
                        if (!stack.empty()) {
                            int val1 = stack.pop();
                            int val2 = stack.pop();
                            stack.push(val2 - val1);
                        }
                        break;
                    case "*":
                        if (!stack.empty()) {
                            int val1 = stack.pop();
                            int val2 = stack.pop();
                            stack.push(val2 * val1);
                        }
                        break;
                    case "/":
                        if (!stack.empty()) {
                            int val1 = stack.pop();
                            int val2 = stack.pop();
                            stack.push(val2 / val1);
                        }
                        break;
                }
            } else {
                stack.push(Integer.parseInt(val));
            }
        }
        return stack.isEmpty() ? 0 : stack.pop();
    }

    public boolean isOperator(String str) {
        if (str.contains("+") || str.contains("-") || str.contains("*") || str.contains("/")) {
            return true;
        }
        return false;
    }
}
