package com.mohit;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        new Solution().nextGreaterElements(new int[]{1, 2, 1});
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] next = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            boolean isFind = false;
            while (j % nums.length != i) {
                if (nums[j % nums.length] > nums[i]) {
                    next[i] = nums[j % nums.length];
                    isFind = true;
                    break;
                }
                j++;
            }
            if (!isFind) {
                next[i] = -1;
            }
        }
        return next;
    }


    public int[] nextGreaterElements2(int[] nums) {
        int[] next = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length * 2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            next[i % nums.length] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return next;
    }

}