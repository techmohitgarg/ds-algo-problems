package com.mohit.leetcode.array.easy;/*
Problem :
-----------
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.

Example 1:
Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0

Url : https://leetcode.com/problems/search-insert-position/description/
*/

public class SearchInsertPosition {

    public static void main(String[] args) {
        SearchInsertPosition rd = new SearchInsertPosition();
        int[] arr = {1, 3, 5, 8};
        int val = 7;
        int result = rd.searchInsert(arr, val);
        System.out.println(result);
    }

    public int searchInsert(int[] nums, int target) {
        return searchPosition1(nums, 0, nums.length, target);
    }

    private int searchPosition(int[] nums, int l, int r, int target) {
        if (r < l) {
            return -1;
        }
        if (r == l) {
            return l;
        }
        int m = (r + l) / 2;
        if (nums[m] < target) {
            return searchPosition(nums, l + 1, r, target);
        }
        return searchPosition(nums, l, r - 1, target);
    }

    private int searchPosition1(int[] nums, int l, int r, int target) {
        while (l < r) {
            int m = (r + l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }


}