package com.mohit.leetcode.stack.easy;

import java.util.Stack;

public class ImplementQueueusingStacks {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        System.out.println(queue.pop());  // returns 1
        queue.push(2);
        System.out.println(queue.peek());
    }

    static class MyQueue {

        Stack<Integer> stack = null;
        Integer top = null;

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
            if (top == null) {
                top = x;
            }
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            int pop = -1;
            if (!stack.isEmpty()) {
                // Return first element from stack
                Stack<Integer> temp = new Stack<>();
                while (stack.size() > 1) {
                    temp.push(stack.pop());
                }
                pop = stack.pop();
                if (!temp.isEmpty()) {
                    top = temp.pop();
                    stack.push(top);
                }
                while (!temp.isEmpty()) {
                    stack.push(temp.pop());
                }
                if (stack.isEmpty()) {
                    top = null;
                }
                return pop;
            }
            top = null;
            return pop;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return top == null ? -1 : top;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack.isEmpty();
        }
    }
}
