package com.mohit.leetcode.array.medium;
/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

import com.mohit.sorting.PrintArray;

public class FindFirstandLastPositionofElementInSorted {

    public static void main(String[] args) {
        FindFirstandLastPositionofElementInSorted element = new FindFirstandLastPositionofElementInSorted();
        new PrintArray().printSingleArray(element.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));

    }

    public int[] searchRange(int[] nums, int target) {
        int start = findRange(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, findRange(nums, target + 1) - 1};
    }

    public int findRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


    public int[] searchRange1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int start = -1;
        int end = -1;
        while (left < nums.length) {
            if (nums[left] == target) {
                start = left;
                break;
            }
            left++;
        }
        while (right >= 0 && left <= right) {
            if (nums[right] == target) {
                end = right;
                break;
            }
            right--;
        }
        if (left == -1 && right == -1) {
            return new int[]{-1, -1};
        }

        return new int[]{start, end};
    }
}
