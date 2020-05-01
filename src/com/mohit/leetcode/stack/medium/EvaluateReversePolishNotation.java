package com.mohit.leetcode.stack.medium;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        System.out.println(new EvaluateReversePolishNotation().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));

    }
    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack = new Stack<>();
        int val2 = 0;
        int val1 = 0;
        for (String val : A) {
            switch (val) {
                case "+":
                    val2 = stack.pop();
                    val1 = stack.pop();
                    stack.push(val1 + val2);
                    break;
                case "-":
                    val2 = stack.pop();
                    val1 = stack.pop();
                    stack.push(val1 - val2);
                    break;
                case "*":
                    val2 = stack.pop();
                    val1 = stack.pop();
                    stack.push(val1 * val2);
                    break;
                case "/":
                    val2 = stack.pop();
                    val1 = stack.pop();
                    stack.push(val1 / val2);
                    break;
                default:
                    stack.push(Integer.parseInt(val));
                    break;
            }
        }
        return stack.pop();
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int val2 = 0;
        int val1 = 0;
        for (String val : tokens) {
            switch (val) {
                case "+":
                    val2 = stack.pop();
                    val1 = stack.pop();
                    stack.push(val1 + val2);
                    break;
                case "-":
                    val2 = stack.pop();
                    val1 = stack.pop();
                    stack.push(val1 - val2);
                    break;
                case "*":
                    val2 = stack.pop();
                    val1 = stack.pop();
                    stack.push(val1 * val2);
                    break;
                case "/":
                    val2 = stack.pop();
                    val1 = stack.pop();
                    stack.push(val1 / val2);
                    break;
                default:
                    stack.push(Integer.parseInt(val));
                    break;
            }
        }
        return stack.pop();
    }
}
