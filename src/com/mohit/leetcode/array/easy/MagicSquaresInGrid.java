package com.mohit.leetcode.array.easy;

/*
A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.

Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).



Example 1:

Input: [[4,3,8,4],
        [9,5,1,9],
        [2,7,6,2]]
Output: 1
Explanation:
The following subgrid is a 3 x 3 magic square:
438
951
276

while this one is not:
384
519
762

In total, there is only one magic square inside the given grid.
Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
0 <= grid[i][j] <= 15

https://leetcode.com/problems/magic-squares-in-grid/
 */

import java.util.HashMap;

public class MagicSquaresInGrid {

    public static void main(String[] args) {
        int[][] grid = {
                {10, 3, 5},
                {1, 6, 11},
                {7, 9, 2}
        };
        MagicSquaresInGrid inGrid = new MagicSquaresInGrid();
        System.out.println(inGrid.numMagicSquaresInside(grid));
    }

    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;

        if (grid == null || grid.length < 3) {
            return count;
        }

        for (int i = 0; i <= grid.length - 3; i++) {
            for (int j = 0; j <= grid[i].length - 3; j++) {
                if (isMagicGrid(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;

    }


    public boolean isMagicGrid(int[][] grid, int i, int j) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if (i > grid.length + 3 || j > grid[i].length + 3) {
            return false;
        }
        int sum = 0;
        // check left to Right
        for (int k = i; k < i + 3; k++) {
            int tempSum = 0;
            for (int l = j; l < j + 3; l++) {
                if (!map.containsKey(grid[k][l]) && grid[k][l] < 10 && grid[k][l] > 0) {
                    tempSum += grid[k][l];
                    map.put(grid[k][l], 1);
                } else {
                    return false;
                }
            }
            if (sum == 0) {
                sum = tempSum;
            } else if (sum != tempSum) {
                return false;
            }
        }
        // check top to bottom
        for (int k = j; k < j + 3; k++) {
            int tempSum = 0;
            for (int l = i; l < i + 3; l++) {
                tempSum += grid[l][k];
            }
            if (sum == 0) {
                sum = tempSum;
            } else if (sum != tempSum) {
                return false;
            }
        }
        // diagonals
        int tempSum = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
        if (tempSum != sum) {
            return false;
        }
        tempSum = grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j];
        if (tempSum != sum) {
            return false;
        }
        return true;
    }

}
