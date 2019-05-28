package com.mohit.array.leetcode;

public class CircularArrayLoop {
    public static void main(String[] args) {
        CircularArrayLoop loop = new CircularArrayLoop();
        System.out.println(loop.circularArrayLoop(new int[]{2, -1, 1, 2, 2}));
    }

    public boolean circularArrayLoop(int[] nums) {
        if (nums.length == 0) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            int start = i;
            int maxLength = 0;
            boolean isNext = nums[i] < 0 ? false : true;
            while (true) {
                if (isNext) {
                    i = ((i + nums[i]) > nums.length) ? (((i + nums[i]) % nums.length) - nums.length) : (i + nums[i])%nums.length;
                } else {
                    i = ((i - Math.abs(nums[i])) < 0) ? (nums.length + ((i - Math.abs(nums[i])) % nums.length)) : (i - Math.abs(nums[i]))%nums.length;
                }
                if (maxLength == Math.abs(i - start) && (start != i)) {
                    return false;
                }
                maxLength = Math.max(maxLength, Math.abs(i - start));
                if (isNext && nums[i] < 0) {
                    return false;
                }
                if (!isNext && nums[i] > 0) {
                    return false;
                }

                if (start == i && maxLength > 1) {
                    return true;
                }
                if (maxLength == Math.abs(i - start) && (start == i)) {
                    return true;
                }
            }
        }
        return false;
    }
}
