package com.mohit.leetcode.array.medium;

/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search.search(nums, 0));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        // find the center point if the array
        int center = getCenter(nums, 0, nums.length - 1);

        if (center == -1) {
            return binarySearch(nums, 0, nums.length, target);
        }
        if (nums[center] == target) {
            return center;
        }
        if (nums[0] > target) {
            return binarySearch(nums, center + 1, nums.length, target);
        }
        return binarySearch(nums, 0, center, target);
    }


    public int getCenter(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            return left;
        }
        int mid = (right + left) / 2;
        if (mid < right && nums[mid] > nums[mid + 1]) {
            return mid;
        }
        if (mid > left && nums[mid] < nums[mid - 1]) {
            return mid - 1;
        }
        if (nums[left] >= nums[mid]) {
            return getCenter(nums, left, mid - 1);
        }
        return getCenter(nums, mid + 1, right);
    }

    public int binarySearch(int[] num, int left, int right, int target) {
        if (left < right) {
            int mid = (right + left) / 2;
            if (num[mid] == target) {
                return mid;
            }
            if (num[mid] > target) {
                return binarySearch(num, left, mid, target);
            }
            return binarySearch(num, mid + 1, right, target);
        }
        return -1;
    }
}
