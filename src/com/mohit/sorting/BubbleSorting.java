/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.sorting;

/**
 *
 * @author mohit
 */
public class BubbleSorting {

    public static void main(String[] args) {
        PrintArray printArray = new PrintArray();
        BubbleSorting is = new BubbleSorting();
        int[] nums = {1, 2, 3, 4, 5, 6};
        is.bubbleSort(nums);
        printArray.printSingleArray(nums);
    }

    private void bubbleSort(int[] nums) {
        int n = nums.length;
        boolean isSort = false;
        for (int i = 0; i < n; i++) {
            isSort = false;
            for (int j = 0; j < n - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isSort = true;
                }
            }
            if (!isSort) {
                break;
            }
        }
    }
}
