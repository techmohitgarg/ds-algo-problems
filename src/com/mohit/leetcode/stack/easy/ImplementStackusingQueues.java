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
        Deque<Integer> head = null;
        public MyStack() {
            head = new LinkedList<>();
        }
        public void push(int x) {
            head.addFirst(x);
        }

        public int pop() {
            if (head.isEmpty()) return -1;
            return head.poll();
        }

        public int top() {
            if (head.isEmpty()) return -1;
            return head.peek();
        }
        public boolean empty() {
            return head.isEmpty();
        }
    }
}
