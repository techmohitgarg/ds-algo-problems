package com.mohit.leetcode.array.easy;

/*
Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].

Example 1:

Input: [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
Example 2:

Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Notes:

1 <= A.length = A[0].length <= 20
0 <= A[i][j] <= 1

https://leetcode.com/problems/flipping-an-image/
 */
class FlipAndInvertImage {


    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] arr : A) {
            int left = 0;
            int right = arr.length - 1;
            while (left <= right) {
                int temp = arr[left];
                arr[left] = getInvert(arr[right]);
                arr[right] = getInvert(temp);
                left++;
                right--;
            }
        }
        return A;
    }

    private int getInvert(int num) {
        return num == 0 ? 1 : 0;
    }

    public int[][] flipAndInvertImage_(int[][] A) {
        for (int[] is : A) {
            int left = 0;
            int right = is.length - 1;
            // Reverse the array
            while (left < right) {
                int temp = is[left];
                is[left] = is[right];
                is[right] = temp;
                left++;
                right--;
            }
            // Convert 0 to 1 and 1 to 0
            left = 0;
            right = is.length;
            while (left < right) {
                is[left] = is[left] == 0 ? 1 : 0;
                left++;
            }
        }
        return A;
    }
}