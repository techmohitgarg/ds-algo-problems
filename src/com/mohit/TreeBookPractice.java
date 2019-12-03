package com.mohit;

import java.util.*;

public class TreeBookPractice {

    public static void main(String[] args) {
        System.out.println(new TreeBookPractice().rob(new int[]{2, 7, 9, 3}));
    }

    public int rob(int[] nums) {
        // Base Case
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int max = 0;
        boolean a = false;
        boolean b = false;
        if (nums[0] > nums[1]) {
            max = nums[0];
            a = true;
        } else {
            max = nums[1];
            b = true;
        }
        int len = nums.length;
        for (int i = 2; i < nums.length; i++) {
            int val1 = (i == len - 1 && (i - 2) == 0) ? 0 : nums[i - 2];
            int val2 = ((i == len - 1 && (i - 3 == 0) ? 0 : (i - 3 < 0) ? 0 : nums[i - 3]));
            if (val1 > val2) {
                nums[i] += a ? 0 : val1;
                if (i - 2 == 0 && !a) {
                    a = true;
                    b = false;
                }
            } else {
                nums[i] += b ? 0 : val2;
                if (i - 3 == 0 && !b) {
                    b = true;
                    a = false;
                }
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}