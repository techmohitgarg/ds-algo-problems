package com.mohit.stacks.leetcode;

import java.util.Stack;

public class Pattern132 {

    public static void main(String[] args) {
        Pattern132 pattern132 = new Pattern132();
        System.out.println(pattern132.find132patternUsingStack(new int[]{3, 1, 4, 2}));
    }

    //i < j < k and ai < ak < aj
    public boolean find132pattern(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] < nums[k] && nums[k] < nums[j]) {
                            System.out.println(i + " " + j + " " + k);
                            return true;
                        }
                    }
                } else {
                    break;
                }

            }
        }
        return false;
    }

    public boolean find132patternUsingStack(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else {
                while (!stack.empty()) {
                    if (stack.peek() >= num) {
                        break;
                    }
                    stack.pop();
                    if (stack.pop() > num) {
                        return true;
                    }
                }
                stack.push(num);
                stack.push(min);
            }
        }
        return false;
    }
}
