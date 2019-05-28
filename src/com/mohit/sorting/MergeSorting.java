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
public class MergeSorting {

    public static void main(String[] args) {
        PrintArray printArray = new PrintArray();
        MergeSorting is = new MergeSorting();
        int[] nums = {12, 11, 13, 5, 6, 7};
        is.mergeSort(nums, 0, nums.length - 1);
        printArray.printSingleArray(nums);
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int m = (r + l) / 2;

            // half the Array in Two Part
            mergeSort(nums, l, m);
            mergeSort(nums, m + 1, r);

            // Merge the Array
            merge(nums, l, r, m);
        }

    }

    private void merge(int[] nums, int l, int r, int m) {
        int sizeL = m - l + 1;
        int sizeR = r - m;
        int[] arrL = new int[sizeL];
        int[] arrR = new int[sizeR];

        for (int i = 0; i < sizeL; i++) {
            arrL[i] = nums[l + i];
        }

        for (int j = 0; j < sizeR; j++) {
            arrR[j] = nums[m + 1 + j];
        }

        int start = l;
        int tempA = 0;
        int tempB = 0;
        while (tempA < sizeL && tempB < sizeR) {
            if (arrL[tempA] <= arrR[tempB]) {
                nums[start] = arrL[tempA];
                tempA++;
            } else {
                nums[start] = arrR[tempB];
                tempB++;
            }
            start++;
        }
        while (tempA < sizeL) {
            nums[start] = arrL[tempA];
            start++;
            tempA++;
        }
        while (tempB < sizeR) {
            nums[start] = arrR[tempB];
            start++;
            tempB++;
        }
    }
}
