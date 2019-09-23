/*
https://leetcode.com/problems/min-stack/
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
 */

package com.mohit.greeksofgreeks.stacks;

import java.util.Stack;

public class MinStack {

    Stack<Integer> min = null;
    Stack<Integer> main = null;

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   //--> Returns -3.
        minStack.pop();
        System.out.println(minStack.top());      //--> Returns 0.
        System.out.println(minStack.getMin());   //--> Returns -2.

    }

    public MinStack() {
        min = new Stack<>();
        main = new Stack<>();
    }

    public void push(int x) {
        // Push In the Main
        main.push(x);
        // check value is greater or less than minValue
        if (min.isEmpty() || min.peek() >= x) {
            min.push(x);
        }
    }

    public void pop() {
        if (!main.isEmpty()) {
            // check pop
            if (!min.isEmpty() && min.peek().intValue() == main.peek().intValue()) {
                min.pop();
            }
            main.pop();
        }
    }

    public int top() {
        if (!main.isEmpty()) {
            return main.peek();
        }
        return -1;
    }

    public int getMin() {
        if (!min.isEmpty()) {
            return min.peek();
        }
        return -1;
    }
}
