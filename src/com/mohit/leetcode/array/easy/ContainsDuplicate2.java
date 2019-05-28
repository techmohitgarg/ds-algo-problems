package com.mohit.leetcode.array.easy;

import java.util.HashMap;
import java.util.HashSet;

/*
Given an array of integers and an integer k, 
find out whether there are two distinct indices i and j in the array such that 
nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false
*/
public class ContainsDuplicate2 {

    public static void main(String[] args) {

        ContainsDuplicate2 duplicate2 = new ContainsDuplicate2();
        int[] arr = {1, 2, 3, 1, 2, 3};
        int k = 10;
        System.out.println((k * (k + 1)) / 2);
        boolean result = duplicate2.containsNearbyDuplicate2(arr, k);
        System.out.println(result);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> maps = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                maps.remove(nums[i - k - 1]);
            }
            if (!maps.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (maps.containsKey(nums[i]) && Math.abs(maps.get(nums[i]) - i) <= k) {
                return true;
            }
            maps.put(nums[i], i);
        }
        return false;
    }
}