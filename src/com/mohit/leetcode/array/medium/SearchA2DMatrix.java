package com.mohit.leetcode.array.medium;

/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
 */
public class SearchA2DMatrix {

    public static void main(String[] args) {
        SearchA2DMatrix matrix = new SearchA2DMatrix();
        int num = 12;
        System.out.println(matrix.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, num));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int l = 0;
        int r = matrix[0].length - 1;
        while (l < matrix.length && r >= 0) {
            if (matrix[l][r] == target) {
                return true;
            } else if (matrix[l][r] < target) {
                l++;
            } else {
                r--;
            }
        }
        return false;
    }


    /*public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        while (left < matrix.length && right >= 0) {
            if (matrix[left][right] == target) {
                return true;
            }
            if (matrix[left][right] > target) {
                right--;
            } else {
                left++;
                right = matrix[0].length - 1;
            }
        }
        return false;
    }*/

    /*public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        for (int[] ints : matrix) {
            if (binarySearch(ints, 0, ints.length, target)) {
                return true;
            }
        }

        return false;
    }

    public boolean binarySearch(int[] num, int left, int right, int target) {
        if (left < right) {
            int mid = (right + left) / 2;
            if (num[mid] == target) {
                return true;
            }
            if (num[mid] > target) {
                return binarySearch(num, left, mid, target);
            }
            return binarySearch(num, mid + 1, right, target);
        }
        return false;
    }*/

}
