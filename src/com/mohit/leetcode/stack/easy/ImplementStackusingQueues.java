package com.mohit.leetcode.stack.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());   // returns 2
        System.out.println(stack.top());   // returns 2
        stack.empty(); // returns false
    }

    static class MyStack {
        Queue<Integer> head = null;
        Integer top = null;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            head = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            head.add(x);
            top = x;
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            Queue<Integer> temp = new LinkedList<>();
            while (head.size() > 1) {
                top = head.remove();
                temp.add(top);
            }
            int pop = -1;
            pop = head.remove();
            head = temp;
            return pop;
        }

        /**
         * Get the top element.
         */
        public int top() {
            if (top != null) return top;
            return -1;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return head.isEmpty();
        }
    }
}
