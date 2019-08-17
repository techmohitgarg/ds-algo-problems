package com.mohit.leetcode.stack.medium;

import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        new DailyTemperatures().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }


    public int[] dailyTemperatures(int[] T) {
        int[] days = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                days[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return days;
    }

}