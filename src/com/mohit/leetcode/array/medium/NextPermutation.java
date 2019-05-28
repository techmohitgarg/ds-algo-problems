package com.mohit.leetcode.array.medium;

import com.mohit.sorting.PrintArray;

import java.util.ArrayList;

/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation permutation = new NextPermutation();
        int[] nums = {2, 1, 3};
        permutation.nextPermutation(nums);
        new PrintArray().printSingleArray(nums);
    }

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int l = nums.length;
        int p = -1;
        for (int i = l - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                p = i;
                break;
            }
        }
        int q = -1;
        if (p != -1) {
            for (int i = l - 1; i >= 0; i--) {
                if (nums[i] > nums[p]) {
                    q = i;
                    break;
                }
            }
        }
        // Inter Change the variables
        if (p != -1) {
            int temp = nums[p];
            nums[p] = nums[q];
            nums[q] = temp;
        }
        int left = p + 1;
        int right = l - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public void nextPermutation(ArrayList<Integer> a) {
        if (a.size() <= 1) {
            return;
        }
        int l = a.size();
        int p = -1;
        for (int i = l - 2; i >= 0; i--) {
            if (a.get(i) < a.get(i + 1)) {
                p = i;
                break;
            }
        }
        int q = -1;
        if (p != -1) {
            for (int i = l - 1; i >= 0; i--) {
                if (a.get(i) > a.get(p)) {
                    q = i;
                    break;
                }
            }
        }
        // Inter Change the variables
        if (p != -1) {
            int temp = a.get(p);
            a.set(p, a.get(q));
            a.set(q, temp);
        }
        int left = p + 1;
        int right = l - 1;
        while (left < right) {
            int temp = a.get(left);
            a.set(left, a.get(right));
            a.set(right, temp);
            left++;
            right--;
        }
    }
}
