package com.mohit.greeksofgreeks.stacks;

import java.util.Stack;

public class MaximumProductIndexesNextGreaterLeftAndRight {

    public static void main(String[] args) {
        System.out.println(new MaximumProductIndexesNextGreaterLeftAndRight().numberNGERight(new int[]{1, 1, 1, 1, 0, 1, 1, 1, 1, 1}));
    }

    //Number of NGEs to the right
    public int numberNGERight(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        // Find ALl the next greater elements
        int[] lf = new int[arr.length];
        int[] rf = new int[arr.length];
        // Find the element which is greater than from right
        while (i < arr.length) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                rf[stack.peek()] = i + 1;
                stack.pop();
            }
            stack.push(i);
            i++;
        }
        // Find the Element which is greater than from left
        i = 0;
        stack.clear();
        while (i < arr.length) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i])
                stack.pop();

            lf[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
            i++;
        }

        int maxLR = 0;
        for (i = 0; i < arr.length; i++) {
            maxLR = Math.max(maxLR, lf[i] * rf[i]);
        }
        return maxLR;
    }

}

