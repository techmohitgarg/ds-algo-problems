package com.mohit.leetcode.array.medium;
/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
https://leetcode.com/problems/spiral-matrix/
 */

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralMatrix.spiralOrder(matrix));
    }

    /*
    [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
    ]
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list;
        }
        int tL = 0;
        int tR = matrix[0].length;
        int bL = 0;
        int bR = matrix.length;
        while (tL < tR && bL < bR) {
            for (int i = tL; i < tR; i++) {
                list.add(matrix[tL][i]);
            }
            tL++;
            for (int i = tL; i < bR; i++) {
                list.add(matrix[i][tR - 1]);
            }
            tR--;
            if (tL < bR) {
                for (int i = tR - 1; i >= bL; i--) {
                    list.add(matrix[bR - 1][i]);
                }
                bR--;
            }
            if (bL < tR) {
                for (int i = bR - 1; i >= tL; i--) {
                    list.add(matrix[i][bL]);
                }
                bL++;
            }
        }

        return list;


    }

    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        ArrayList<Integer> list = new ArrayList();
        if (A.size() == 0) {
            return list;
        }
        int q_Left = 0;
        int q_right = A.get(0).size();
        int p_top = 0;
        int p_bottom = A.size();
        while (p_top < p_bottom && q_Left < q_right) {
            // Top
            for (int i = p_top; i < q_right; i++) {
                list.add(A.get(p_top).get(i));
            }
            p_top++;
            // Right
            for (int i = p_top; i < p_bottom; i++) {
                list.add(A.get(i).get(q_right - 1));
            }
            q_right--;

            // Bottom
            if (p_top < p_bottom) {
                for (int i = q_right - 1; i >= q_Left; i--) {
                    list.add(A.get(p_bottom - 1).get(i));
                }
                p_bottom--;
            }
            //Left
            if (q_Left < q_right) {
                for (int i = p_bottom - 1; i >= p_top; i--) {
                    list.add(A.get(i).get(q_Left));
                }
                q_Left++;
            }
        }
        return list;
    }
}
