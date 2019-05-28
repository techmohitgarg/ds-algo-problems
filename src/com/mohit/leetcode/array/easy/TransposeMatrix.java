package com.mohit.leetcode.array.easy;

/*
Given a matrix A, return the transpose of A.

The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.



Example 1:

Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
Example 2:

Input: [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]


Note:

1 <= A.length <= 1000
1 <= A[0].length <= 1000
https://leetcode.com/problems/transpose-matrix/
 */
public class TransposeMatrix {

    public static void main(String[] args) {
        TransposeMatrix matrix = new TransposeMatrix();
        matrix.transpose(new int[][]{
                {1, 2, 3},
                {4, 5, 6}});

    }

    public int[][] transpose(int[][] A) {
        int[][] trans = new int[A[0].length][A.length];
        for (int i = 0; i < trans.length; i++) {
            for (int j = 0; j < trans[0].length; j++) {
                trans[i][j] = A[j][i];
            }
        }
        return trans;
    }
}
