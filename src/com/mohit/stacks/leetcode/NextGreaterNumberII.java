package com.mohit.stacks.leetcode;

import java.util.Stack;

public class NextGreaterNumberII {

    public static void main(String[] args) {
        NextGreaterNumberII numberII = new NextGreaterNumberII();
        numberII.nextGreaterElements1(new int[]{1, 2, 1});
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] values = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int j;
            if (i == nums.length - 1) {
                j = 0;
            } else {
                j = i + 1;
            }
            while (j != i) {
                if (nums[i] < nums[j]) {
                    values[i] = nums[j];
                    break;
                }
                if (j == nums.length - 1) {
                    j = 0;
                } else {
                    j++;
                }
            }
            if (j == i) {
                values[i] = -1;
            }
        }
        return values;
    }

    public int[] nextGreaterElements1(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }

    // 1,2,1
    public int[] nextGreaterElementsUsingStack(int[] nums) {
        int[] values = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            int j;
            if (i == nums.length - 1) {
                j = 0;
            } else {
                j = i + 1;
            }
            while (stack.empty() == false) {
                if (nums[stack.peek()] < nums[j]) {
                    values[stack.pop()] = nums[j];
                }
                if (stack.empty()) {
                    break;
                }
            }
            stack.push(i);

        }
        return values;
    }

}
