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
public class InsertionSorting {

    public static void main(String[] args) {
        PrintArray printArray = new PrintArray();
        InsertionSorting is = new InsertionSorting();
        int[] nums = {12, 11, 13, 5, 6};
        is.insertionSort(nums);
        printArray.printSingleArray(nums);
    }

    private void insertionSort(int[] nums) {
        int n = nums.length;

        // Idea 1
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int j = i - 1;
            while (j >= 0 && num < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = num;
        }

        // Idea 2 
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

    }
}
