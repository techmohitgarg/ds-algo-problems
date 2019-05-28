/*
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 */
package com.mohit.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author mohit
 */
public class SortColors {

    public static void main(String[] args) {
        SortColors intervals = new SortColors();
        int[] nums = {2, 0, 2, 2, 2, 2, 2, 1, 1, 0};
        intervals.sortColors(nums);
    }

    public void sortColors(int[] nums) {

        int red = 0;
        int white = 0;
        int blue = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                red++;
            }
            if (nums[i] == 1) {
                white++;
            }
            if (nums[i] == 2) {
                blue++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (red > i) {
                nums[i] = 0;
                continue;
            }
            if (red + white > i) {
                nums[i] = 1;
                continue;
            }
            if (red + white + blue > i) {
                nums[i] = 2;
                continue;
            }
        }

        new PrintArray().printSingleArray(nums);
    }
}
