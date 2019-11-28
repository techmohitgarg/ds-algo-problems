package com.mohit.leetcode.dynamic_programming.easy;

public class RangeSumQueryImmutable {

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }


    static class NumArray {
        int[] leftSum = null;
        int[] rightSum = null;
        int len = 0;
        int totalSum = 0;

        public NumArray(int[] nums) {
            len = nums.length;
            if (len > 0) {
                leftSum = new int[len + 1];
                for (int i = 0; i < nums.length; i++) {
                    leftSum[i + 1] = leftSum[i] + nums[i];
                }
            }
        }

        public int sumRange(int i, int j) {
            return leftSum[j+1]-leftSum[i];
        }
        /*public NumArray(int[] nums) {
            len = nums.length;
            if (len > 0) {
                leftSum = new int[len];
                rightSum = new int[len];
                for (int i = 0; i < nums.length; i++) {
                    leftSum[i] = (i == 0) ? nums[i] : leftSum[i - 1] + nums[i];
                    rightSum[len - i - 1] = (i == 0) ? nums[len - i - 1] : rightSum[len - i] + nums[len - i - 1];
                }
                totalSum = leftSum[len - 1];
            }

        }

        public int sumRange(int i, int j) {
            if (len > 0) {
                int left = ((i - 1 < 0) ? 0 : leftSum[i - 1]);
                int right = ((j + 1 >= len) ? 0 : rightSum[j + 1]);
                int range = totalSum - (left + right);
                return range;
            }
            return 0;
        }*/
    }
}