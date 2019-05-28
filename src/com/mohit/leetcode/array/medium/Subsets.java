package com.mohit.leetcode.array.medium;
/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
https://leetcode.com/problems/subsets/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        makeSubsets(lists, new ArrayList<>(), nums, 0);
        return lists;
    }

    private void makeSubsets(List<List<Integer>> lists, List<Integer> integers, int[] nums, int start) {
        if (start <= nums.length) {
            lists.add(new ArrayList<>(integers));
        }
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            integers.add(nums[i]);
            makeSubsets(lists, integers, nums, i + 1);
            integers.remove(integers.size() - 1);
        }

    }

}
