package com.mohit.leetcode.array.easy;

import java.util.Arrays;
import java.util.HashMap;

/*
Problem 1 :
-----------
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

Url : https://leetcode.com/problemset/all/?difficulty=Easy&topicSlugs=array
*/

public class TwoSum {
    public static void main(String[] args) {
        System.out.println("Hello World");
        TwoSum twoSum = new TwoSum();
        int[] arr = {3, 2, 4};
        int target = 6;
        int[] result = twoSum.twoSum1(arr, target);
        for (int var : result) {
            System.out.print(var);
            System.err.print(" ");
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer val = temp.get(target - nums[i]);
            if (val == null) {
                temp.put(nums[i], i);
            } else {
                result[0] = val;
                result[1] = i;
                return result;
            }
        }
        return null;
    }


    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                result[0] = left;
                result[1] = right;
                return result;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
}
