package com.mohit.leetcode.stack.easy;

import java.util.Stack;

public class MinStackProblem {

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());      //--> Returns 0.
        System.out.println(minStack.getMin());   //--> Returns -2.
    }


    static class MinStack {
        Stack<Integer> stack = null;
        Integer min = null;

        public MinStack() {
            stack = new Stack<>();
            min = null;
        }

        public void push(int x) {
            stack.push(x);
            if (min == null || min > x) {
                min = x;
            }
            stack.push(min);
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                stack.pop();
            }
            if (!stack.isEmpty())
                min = stack.peek();
            else
                min = null;
        }

        public int top() {
            if (!stack.isEmpty()) {
                int temp = stack.pop();
                int top = stack.peek();
                stack.push(temp);
                return top;
            }
            return -1;
        }

        public int getMin() {
            return min == null ? -1 : min;
        }
    }
    /*static class MinStack {
        Stack<Integer> stack = null;
        Stack<Integer> min = null;

        public MinStack() {
            stack = new Stack<>();
            min = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (min.isEmpty() || min.peek().intValue() >= x) {
                min.push(x);
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                if (!min.isEmpty() && min.peek().intValue() == stack.peek().intValue()) {
                    min.pop();
                }
                stack.pop();
            }
        }

        public int top() {
            if (!stack.isEmpty()) return stack.peek();
            return -1;
        }

        public int getMin() {
            return min.isEmpty() ? -1 : min.peek();
        }
    }*/
}
