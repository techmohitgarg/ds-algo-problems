package com.mohit;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }


    // Using Array
    public int trap1(int[] height) {
        int trapWater = 0;
        int n = height.length;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for (int i = 0; i < n; i++) {
            left[i] = (i == 0 ? height[i] : Math.max(left[i - 1], height[i]));
            right[n - i - 1] = (i == 0 ? height[n - i - 1] : Math.max(right[n - i], height[n - i - 1]));
        }

        for (int i = 0; i < n; i++) {
            trapWater += Math.abs(Math.min(left[i], right[i]) - height[i]);
        }

        return trapWater;
    }

    // Using Stack
    public int trap(int[] height) {
        int trapWater = 0;
        int n = height.length;
        Stack<Integer> stack = new Stack<>();




        return trapWater;
    }


}