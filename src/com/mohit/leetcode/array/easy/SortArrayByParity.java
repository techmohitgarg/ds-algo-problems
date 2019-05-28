package com.mohit.leetcode.array.easy;

/*
Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.



Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.


Note:

1 <= A.length <= 5000
0 <= A[i] <= 5000
https://leetcode.com/problems/sort-array-by-parity/
 */
public class SortArrayByParity {
    public static void main(String[] args) {
        SortArrayByParity array = new SortArrayByParity();
        array.sortArrayByParity(new int[]{3, 1, 2, 4});
    }

    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }

        int i = 0;
        int j = 0;
        while (j < A.length) {
            if (A[j] % 2 == 0) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                j++;
                i++;
            }
        }
        return A;

    }

    public int[] sortArrayByParity1(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }

        int[] sortNum = new int[A.length];
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                sortNum[index++] = A[i];
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 1) {
                sortNum[index++] = A[i];
            }
        }
        return sortNum;
    }
}
