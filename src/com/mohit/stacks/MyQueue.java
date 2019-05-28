/*
https://leetcode.com/problems/implement-queue-using-stacks/
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Example:

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false
Notes:

You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */
package com.mohit.stacks;

import java.util.Stack;

class MyQueue {

    Stack<Integer> stack;

    public static void main(String[] args) {

    }

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (!stack.empty()) {
            Stack<Integer> temp = new Stack<>();
            while (!stack.empty()) {
                temp.push(stack.pop());
            }

            int val = temp.pop();
            while (!temp.empty()) {
                stack.push(temp.pop());
            }
            return val;
        }
        return -1;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!stack.empty()) {
            Stack<Integer> temp = new Stack<>();
            while (!stack.empty()) {
                temp.push(stack.pop());
            }

            int val = temp.peek();
            while (!temp.empty()) {
                stack.push(temp.pop());
            }
            return val;
        }
        return -1;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.empty();
    }
}