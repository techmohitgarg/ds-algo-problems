package com.mohit.leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesinanArray {

    public static void main(String[] args) {
        FindAllDuplicatesinanArray duplicatesinanArray = new FindAllDuplicatesinanArray();
        System.out.println(duplicatesinanArray.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public List<Integer> findDuplicates(int[] nums) {
        /*List<Integer> list = new ArrayList<>();
        int[] data = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            data[nums[i]] += 1;
            if (data[nums[i]] == 2) {
                list.add(nums[i]);
            }
        }
        return list;*/
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            } else {
                results.add(Math.abs(nums[i]));
            }
        }
        return results;

    }
}
