package com.mohit.leetcode.array.easy;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class FindAllNumbersDisappeared {
    public static void main(String[] args) {
        FindAllNumbersDisappeared disappeared = new FindAllNumbersDisappeared();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = disappeared.findDisappearedNumbers1(nums);
        System.out.println(result);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.length; ) {
            if (count == nums[i]) {
                i++;
                continue;
            }
            if ((count + 1) == nums[i]) {
                count++;
                i++;
                continue;
            }
            list.add(count + 1);
            count++;
        }
        if (count < nums.length) {
            for (int i = count + 1; i <= nums.length; i++) {
                list.add(i);
            }
        }
        return list;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int i = 0;
        int num = 1;
        while (i < nums.length && num <= n) {
            if (nums[i] == num) {
                i++;
                num++;
            } else if (nums[i] < num && nums[i] != num) {
                i++;
            } else {
                list.add(num++);
            }
        }
        while (num <= n) {
            list.add(num++);
        }
        return list;
    }
}