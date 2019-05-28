package com.mohit.leetcode.array.medium;

/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
https://leetcode.com/problems/rotate-image/
 */

import com.mohit.sorting.PrintArray;

public class RotateImage {

    public static void main(String[] args) {
        RotateImage image = new RotateImage();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        image.rotate(matrix);

    }

    public void rotate(int[][] matrix) {
        int i = 0;
        int bottom = matrix.length - 1;
        while (i < bottom) {
            int j = 0;
            while (j < matrix[i].length) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - i][j];
                matrix[matrix.length - 1 - i][j] = temp;
                j++;
            }
            i++;
            bottom--;
        }
        new PrintArray().printDoubleArray(matrix);
        System.out.println();
        for (i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        new PrintArray().printDoubleArray(matrix);
    }
}
