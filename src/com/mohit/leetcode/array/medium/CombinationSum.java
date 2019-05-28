package com.mohit.leetcode.array.medium;
/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
https://leetcode.com/problems/combination-sum/
 */
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum sum = new CombinationSum();
        System.out.println(sum.combinationSum(new int[]{2, 3, 5}, 8));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
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
            integers.add(candidates[i]);
            groupSet(list, integers, candidates, target - candidates[i], i);
            integers.remove(integers.size() - 1);
        }
    }

}
