package com.mohit.leetcode.stack.medium;

import com.mohit.Solution;

import java.util.HashMap;

public class DesignStackWithIncrementOperation {

    public static void main(String[] args) {
        DesignStackWithIncrementOperation sol = new DesignStackWithIncrementOperation();
        //["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
        //[[3],[1],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]
        CustomStack stack = new CustomStack(3);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.increment(5, 100);
        stack.increment(2, 100);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    static class CustomStack {

        private int len = 0;
        private int[] stack = null;
        private int index = -1;

        public CustomStack(int maxSize) {
            len = maxSize;
            stack = new int[len];
        }

        public void push(int x) {
            if (index + 1 < len) {
                stack[++index] = x;
            }
        }

        public int pop() {
            if (index < 0) {
                return -1;
            }
            int val = stack[index--];
            return val;
        }

        public void increment(int k, int val) {
            int i = 0;
            while (i <= index && k > 0) {
                stack[i] += val;
                i++;
                k--;
            }
        }

    }


}