package com.mohit.leetcode.array.easy;

public class MatrixDiagonalSum {

    /*
        TC : O(N)
        SC : O(1)
     */
    public int diagonalSum(int[][] mat) {
        int result = 0;
        int len = mat.length;
        for (int i = 0; i < len; i++) {
            // for top-left
            result += mat[i][i];
            //for top-right
            result += mat[i][len - i - 1];
            if ((len % 2 != 0) && (len / 2) == i) {
                result -= mat[i][len - i - 1];
            }
        }

        return result;
    }

}
