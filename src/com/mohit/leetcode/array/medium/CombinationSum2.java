package com.mohit.leetcode.array.medium;
/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
https://leetcode.com/problems/combination-sum-ii/
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public static void main(String[] args) {
        CombinationSum2 sum = new CombinationSum2();
        System.out.println(sum.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        groupSet(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    public void groupSet(List<List<Integer>> list, List<Integer> integers, int[] candidates, int target, int start) {
        if (target == 0) {
            list.add(new ArrayList<>(integers));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            integers.add(candidates[i]);
            groupSet(list, integers, candidates, target - candidates[i], i + 1);
            integers.remove(integers.size() - 1);
        }
    }

}
