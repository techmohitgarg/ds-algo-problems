package com.mohit.leetcode.array.easy;

import java.util.Arrays;

/*
Given an array of integers, find if the array contains any duplicates.
Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:
Input: [1,2,3,1]
Output: true

Example 2:
Input: [1,2,3,4]
Output: false

Example 3:
Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
Url : https://leetcode.com/problems/contains-duplicate/description/
*/
public class ContainsDuplicate {

    public static void main(String[] args) {

        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int[] arr = { 1,1,1,3,3,4,3,2,4,2 };
        boolean result = containsDuplicate.containsDuplicate(arr);
        System.out.println(result);

    }

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0 || nums[i] != nums[count - 1]) {
                count++;
            } else {
                return true;
            }
        }
        return false;
    }
}