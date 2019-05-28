package com.mohit.stacks;

import java.util.Stack;

public class Baseballgame {
    public static void main(String[] args) {
        Baseballgame baseballgame = new Baseballgame();
        System.out.println(baseballgame.calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }

    public int calPoints(String[] ops) {
        if (ops.length == 0) {
            return 0;
        }
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            String val = ops[i];
            switch (val) {
                case "C":
                    if (!stack.empty()) {
                        sum -= stack.pop();
                    }
                    break;
                case "D":
                    if (!stack.empty()) {
                        int temp = stack.peek() * 2;
                        sum += temp;
                        stack.push(temp);
                    }
                    break;
                case "+":
                    if (!stack.empty()) {
                        int match2 = stack.pop();
                        int match1 = stack.peek();
                        stack.push(match2);
                        stack.push(match1 + match2);
                        sum += stack.peek();
                    }
                    break;
                default:
                    int temp = Integer.parseInt(val);
                    stack.push(temp);
                    sum += temp;
                    break;
            }


        }
        return sum;
    }
}
