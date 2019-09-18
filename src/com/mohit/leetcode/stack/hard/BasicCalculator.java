package com.mohit.leetcode.stack.hard;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        System.out.println(new BasicCalculator().calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Character> opt = new Stack<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') continue;
            if (s.charAt(i) == '(') {
                if (num != 0)
                    stack.push(num);
                opt.push(s.charAt(i));
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                // Check if the Operator stack is not empty
                if (!opt.isEmpty() && opt.peek() != '(') {
                    // get the last updated value from stack
                    int prev = stack.isEmpty() ? 0 : stack.pop();
                    char action = opt.pop();
                    if (action == '+') {
                        num = prev + num;
                    } else {
                        num = prev - num;
                    }
                }
                // Pushing the current operator in stack
                opt.push(s.charAt(i));
                // Adding the new Value in the stack
                stack.push(num);
                //Updating the value
                num = 0;
            } else if (s.charAt(i) == ')') {
                //  Getting Last Operator
                char action = opt.isEmpty() ? ' ' : opt.pop();
                if (action != ' ' && action != '(') {
                    // Getting Last Calculated Value
                    int prev = stack.isEmpty() ? 0 : stack.pop();
                    if (action != ' ') {
                        if (action == '+') {
                            num = prev + num;
                        } else {
                            num = prev - num;
                        }
                    }
                }
                // Remove open bracket
                if (!opt.isEmpty() && opt.peek() == '(') opt.pop();
                // Adding previous value that was from starting the bracket
                // Get the Action that from starting the bracket
                action = opt.isEmpty() ? ' ' : opt.pop();
                if (action != ' ') {
                    // Getting Last Calculated Value
                    int prev = stack.isEmpty() ? 0 : stack.pop();
                    if (action == '+') {
                        num = prev + num;
                    } else {
                        num = prev - num;
                    }
                }
            } else {
                // Adding Number Values
                num = 10 * num + (s.charAt(i) - '0');
            }
        }


        // Adding the last if exist
        char action = opt.isEmpty() ? ' ' : opt.pop();
        if (action != ' ') {
            // Getting Last Calculated Value
            int prev = stack.isEmpty() ? 0 : stack.pop();
            if (action != ' ') {
                if (action == '+') {
                    num = prev + num;
                } else {
                    num = prev - num;
                }
            }
        }
        num = stack.isEmpty() ? num : stack.pop();
        return num;
    }
}