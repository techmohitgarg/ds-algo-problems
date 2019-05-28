package com.mohit.leetcode.array.medium;
/*
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
https://leetcode.com/problems/spiral-matrix-ii/
 */

import com.mohit.sorting.PrintArray;

import java.util.ArrayList;

public class SpiralMatrixTwo {

    public static void main(String[] args) {
        SpiralMatrixTwo spiralMatrix = new SpiralMatrixTwo();
        new PrintArray().printDoubleArray(spiralMatrix.generateMatrix(3));
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (matrix.length == 0) {
            return matrix;
        }
        int tL = 0;
        int tR = n;
        int bL = 0;
        int bR = n;
        int count = 1;
        while (tL < tR && bL < bR) {
            for (int i = tL; i < tR; i++) {
                matrix[tL][i] = count++;
            }
            tL++;
            for (int i = tL; i < bR; i++) {
                matrix[i][tR - 1] = count++;
            }
            tR--;
            if (tL < bR) {
                for (int i = tR - 1; i >= bL; i--) {
                    matrix[bR - 1][i] = count++;
                }
                bR--;
            }
            if (bL < tR) {
                for (int i = bR - 1; i >= tL; i--) {
                    matrix[i][bL] = count++;
                }
                bL++;
            }
        }
        return matrix;
    }

    public ArrayList<ArrayList<Integer>> generateMatrix1(int A) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        int[][] matrix = new int[A][A];
        if (matrix.length == 0) {
            return arrayLists;
        }
        int tL = 0;
        int tR = A;
        int bL = 0;
        int bR = A;
        int count = 1;

        while (tL < tR && bL < bR) {
            for (int i = tL; i < tR; i++) {
                matrix[tL][i] = count++;
            }
            tL++;
            for (int i = tL; i < bR; i++) {
                matrix[i][tR - 1] = count++;
            }
            tR--;
            if (tL < bR) {
                for (int i = tR - 1; i >= bL; i--) {
                    matrix[bR - 1][i] = count++;
                }
                bR--;
            }
            if (bL < tR) {
                for (int i = bR - 1; i >= tL; i--) {
                    matrix[i][bL] = count++;
                }
                bL++;
            }
        }
        for (int[] ints : matrix) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int n : ints) {
                list.add(n);
            }
            arrayLists.add(list);
        }

        return arrayLists;
    }
}
