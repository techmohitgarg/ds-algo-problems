package com.mohit.leetcode.array.medium;
/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
Accepted
https://leetcode.com/problems/subsets-ii/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public static void main(String[] args) {
        SubsetsII subsets = new SubsetsII();
        System.out.println(subsets.subsetsWithDup(new int[]{1, 1}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            integers.add(nums[i]);
            makeSubsets(lists, integers, nums, i + 1);
            integers.remove(integers.size() - 1);
        }

    }

}
