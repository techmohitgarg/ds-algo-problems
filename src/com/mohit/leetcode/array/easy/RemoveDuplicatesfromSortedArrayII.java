package com.mohit.leetcode.array.easy;
/*
Url : https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
*/

public class RemoveDuplicatesfromSortedArrayII {

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArrayII rd = new RemoveDuplicatesfromSortedArrayII();
        int[] arr = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int result = rd.removeDuplicates(arr);
        System.out.println(result);
    }

    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; ) {
            int start = i;
            int size = 0;
            while (start < nums.length && nums[i] == nums[start]) {
                if (size < 2) {
                    nums[count] = nums[start];
                    count++;
                    size++;
                }
                start++;
            }
            i = start;
        }
        return count;
    }
}