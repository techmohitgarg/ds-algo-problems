package com.mohit.leetcode.array.easy;

/*
In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Example 1:
Input: 
nums = 
[[1,2],
 [3,4]]
r = 1, c = 4
Output: 
[[1,2,3,4]]
Explanation:
The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.

Example 2:
Input: 
nums = 
[[1,2],
 [3,4]]
r = 2, c = 4
Output: 
[[1,2],
 [3,4]]
Explanation:
There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.

Note:
The height and width of the given matrix is in range [1, 100].
The given r and c are all positive.

https://leetcode.com/problems/reshape-the-matrix/
*/
class ReshapetheMatrix {
    public static void main(String[] args) {
        ReshapetheMatrix reshapetheMatrix = new ReshapetheMatrix();
        int[][] nums = { { 1, 2 }, { 3, 4 } };
        int r = 1;
        int c = 4;
        int[][] result = reshapetheMatrix.matrixReshape(nums, r, c);
        for (int[] i : result) {
            for (int j : i) {
                System.out.print(j);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] modified = new int[r][c];

        int row = 0;
        int col = 0;

        if (nums.length <= 0) {
            return modified;
        }
        if ((r * c) != (nums.length * nums[0].length)) {
            return modified;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (col < c) {
                    modified[row][col++] = nums[i][j];
                }
                if (col == c) {
                    row++;
                    col = 0;
                }
            }
        }
        return modified;
    }
}