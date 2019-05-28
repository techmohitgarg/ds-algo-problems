package com.mohit.leetcode.array.easy;

public class ValidMountainArray {

    public static void main(String[] s) {
        ValidMountainArray array = new ValidMountainArray();

        System.out.println(array.validMountainArray(new int[]{0, 3, 5, 6}));
    }

    public boolean validMountainArray(int[] A) {
        if (A.length <= 2) {
            return false;
        }
        if (A[0] != 0) {
            return false;
        }

        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] <= A[i + 1]) {
                return false;
            }

        }
        return true;
    }
}
