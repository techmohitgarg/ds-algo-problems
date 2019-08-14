package com.mohit.leetcode.stack.medium;

import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        new AsteroidCollision().asteroidCollision(new int[]{10, 2, -5});
    }

    //5, 10, -5
    //8, -8
    //10, 2, -5
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int val = asteroids[i];
            boolean isAdd = false;
            while (!stack.isEmpty() && stack.peek() > 0 && val < 0) {
                if (stack.peek() < -val) {
                    stack.pop();
                    continue;
                } else if (stack.peek() == -val) {
                    stack.pop();
                }
                isAdd = true;
                break;
            }
            if (!isAdd)
                stack.push(val);

        }
        System.out.println(stack);
        int[] data = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.empty()) {
            data[i] = stack.pop();
            i--;
        }
        return data;

    }
}