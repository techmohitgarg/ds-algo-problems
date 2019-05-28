package com.mohit.array.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicatesinanArray {

    public static void main(String[] args) {
        FindAllDuplicatesinanArray duplicatesinanArray = new FindAllDuplicatesinanArray();
        System.out.println(duplicatesinanArray.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums.length <= 1) {
            return list;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                list.add(nums[i]);
            }
        }
        return list;
    }
}
