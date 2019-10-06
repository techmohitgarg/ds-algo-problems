package com.mohit;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] num = {2, 1, 5, 6, 2, 3};
        ArrayList<Integer> integers = new ArrayList<>();
        for (int n : num) {
            integers.add(n);
        }
        new Solution().largestRectangleArea(integers);
    }


    public int largestRectangleArea(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int maxArea = 0;
        while (i < A.size()) {
            if (stack.isEmpty() || A.get(stack.peek()) <= A.get(i)) {
                stack.push(i++);
            } else {
                int top = stack.peek();
                stack.pop();
                int areaCalculated = A.get(top) * (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, areaCalculated);
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.peek();
            stack.pop();
            int areaCalculated = A.get(top) * (stack.isEmpty() ? i : i - stack.peek() - 1);
            maxArea = Math.max(maxArea, areaCalculated);
        }
        return maxArea;
    }


}

