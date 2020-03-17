package com.mohit;

import com.mohit.leetcode.linklist.ListNode;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.thirdMax(new int[]{2, 2, 1, 5}));
    }

    public int thirdMax(int[] nums) {

        //start base case
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        //end base case
        Integer first = null;
        Integer second = null;
        Integer third = null;

        for (int i = 0; i < nums.length; i++) {
            Integer val = nums[i];
            if (val.equals(first) || val.equals(second) || val.equals(third)) continue;

            if (first == null || first < val) {
                third = second;
                second = first;
                first = val;
            } else if (second == null || second < val) {
                third = second;
                second = val;
            } else if (third == null || third < val) {
                third = val;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (first == null) first = nums[i];
            else first = Math.max(first, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < first) {
                if (second == null) second = nums[i];
                else second = Math.max(second, nums[i]);
            }
        }
        if (second == null) return first;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < second) {
                if (third == null) third = nums[i];
                else third = Math.max(third, nums[i]);
            }
        }
        return third == null ? first : third;
    }
}

