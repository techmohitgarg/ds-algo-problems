package com.mohit.leetcode.stack.hard;

import java.util.HashMap;
import java.util.Stack;

class FreqStack {
    HashMap<Integer, Integer> hashMap = null;
    Stack<Integer> stack = null;
    Integer max = 0;

    public static void main(String[] args) {
        FreqStack stack = new FreqStack();
        //[[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
        stack.push(5);
        stack.push(7);
        stack.push(5);
        stack.push(7);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

    public FreqStack() {
        hashMap = new HashMap<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        max = Math.max(max, hashMap.get(x));
    }

    public int pop() {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty() && hashMap.get(stack.peek()) != max) {
            temp.push(stack.pop());
        }
        // Remove the top value if equal to maxValue
        if (!stack.isEmpty() && hashMap.get(stack.peek()) == max) {
            stack.pop();
        }
        // Add temp value in the original stack
        while (!temp.isEmpty()) stack.push(temp.pop());
        return 0;
    }
}