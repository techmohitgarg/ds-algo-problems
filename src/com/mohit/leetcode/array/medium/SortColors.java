package com.mohit.leetcode.array.medium;
/*
https://leetcode.com/problems/sort-colors/
 */

import java.util.ArrayList;
import java.util.List;

public class SortColors {

    public static void main(String[] args) {
        SortColors sum = new SortColors();
        new SortColors().sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }

    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;
        for (int color : nums) {
            switch (color) {
                case 0:
                    red++;
                    break;
                case 1:
                    white++;
                    break;
                case 2:
                    blue++;
                    break;
            }
        }
        int i = 0;
        while (i < nums.length) {
            if (red > 0) {
                nums[i] = 0;
                red--;
            } else if (white > 0) {
                nums[i] = 1;
                white--;
            } else if (blue > 0) {
                nums[i] = 2;
                blue--;
            }
            i++;
        }

    }
}
