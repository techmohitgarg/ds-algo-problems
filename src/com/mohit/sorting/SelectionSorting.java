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
public class SelectionSorting {

    public static void main(String[] args) {
        PrintArray printArray = new PrintArray();
        SelectionSorting is = new SelectionSorting();
        int[] nums = {4, 24, 5, 7, 3,3,4,5,6,3,7,2,6,70};
        is.selectionSort(nums);
        printArray.printSingleArray(nums);
    }

    private void selectionSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        }
    }
}
