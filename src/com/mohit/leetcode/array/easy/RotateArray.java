package com.mohit.leetcode.array.easy;/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?

Url :https://leetcode.com/problems/rotate-array/description/
*/

public class RotateArray {

    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        //[5,6,7,1,2,3,4]
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        ra.rotate(arr, k);
    }

    //with o(n) space
    public void rotate(int[] nums, int k) {
        int[] rotate = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            rotate[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = rotate[i];
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }

    public void rotate1(int[] nums, int k) {
        while (k > 0) {
            int j = nums.length - 1;
            int temp = nums[j];
            while (j > 0) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
            k--;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }
}