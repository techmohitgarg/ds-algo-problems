package com.mohit.leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public static void main(String[] args) {
        CombinationSumIII sumIII = new CombinationSumIII();
        System.out.println(sumIII.combinationSum3(0, 0));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        combination(list, new ArrayList<>(), 1, k, n);
        return list;
    }


    public void combination(List<List<Integer>> lists, List<Integer> integers, int start, int k, int n) {
        if (integers.size() == k && n == 0) {
            lists.add(new ArrayList<>(integers));
        }
        if (integers.size() > k || n <= 0) {
            return;
        }

        for (int i = start; i < 10; i++) {
            integers.add(i);
            combination(lists, integers, i + 1, k, n - i);
            integers.remove(integers.size() - 1);
        }
    }


}
