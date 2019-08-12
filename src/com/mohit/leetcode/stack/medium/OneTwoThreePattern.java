package com.mohit.leetcode.stack.medium;

import java.util.Stack;

public class OneTwoThreePattern {

    public static void main(String[] args) {
        System.out.println(new OneTwoThreePattern().find132pattern(new int[]{-1, 2, 0}));
    }

    /*//i < j < k and ai < ak < aj
    public boolean find132pattern(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] < nums[k] && nums[k] < nums[j]) {
                            return true;
                        }
                    }
                } else {
                    break;
                }

            }
        }
        return false;
    }*/

    public boolean find132pattern(int[] nums) {
        if (nums.length <= 2) return false;
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<=min) {
                min = nums[i];
            } else {
                while (!stack.isEmpty()) {
                    if (stack.peek() >= nums[i]) {
                        break;
                    }
                    stack.pop();
                    if (!stack.isEmpty() && stack.pop() > nums[i]) {
                        return true;
                    }
                }

                stack.push(nums[i]);
                stack.push(min);

            }
        }
        return false;
    }
}