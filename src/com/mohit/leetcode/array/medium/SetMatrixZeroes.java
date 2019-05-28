package com.mohit.leetcode.array.medium;

/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input:
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output:
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
 */

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        SetMatrixZeroes zeroes = new SetMatrixZeroes();
        zeroes.setZeroes(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});

    }


    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int row = list.get(i)[0];
            int col = list.get(i)[1];
            int j = 0;
            while (j < matrix[0].length) {
                matrix[row][j] = 0;
                j++;
            }
            j = 0;
            while (j < matrix.length) {
                matrix[j][col] = 0;
                j++;
            }
        }
    }


    /*    public void setZeroes(int[][] matrix) {
            if (matrix.length == 0) {
                return;
            }
            int[][] num = new int[matrix.length][matrix[0].length];
            // Check left to Right
            for (int i = 0; i < num.length; i++) {
                for (int j = 0; j < num[i].length; j++) {
                    if (matrix[i][j] == 0) {
                        for (int k = 0; k < num[i].length; k++) {
                            num[i][k] = 2;
                        }
                        break;
                    }
                }
            }
            for (int i = 0; i < num[0].length; i++) {
                for (int j = 0; j < num.length; j++) {
                    if (matrix[j][i] == 0) {
                        for (int k = 0; k < num.length; k++) {
                            num[k][i] = 2;
                        }
                        break;
                    }

                }
            }
            for (int i = 0; i < num.length; i++) {
                for (int j = 0; j < num[0].length; j++) {
                    if (num[i][j] == 2) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }*/
}
