package com.mohit.leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
Link : https://leetcode.com/problems/pascals-triangle/description/
*/

public class PascalTriangle {
    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();
        System.out.println(pt.generate(1));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        List<Integer> row = new ArrayList();
        for (int i = 0; i < numRows; i++) {
            row = getRows(row, i);
            pascal.add(row);
        }
        return pascal;
    }


    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> pascal = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList();
        for (int i = 0; i < A; i++) {
            row = getRows(row, i);
            pascal.add(row);
        }
        return pascal;
    }

    public ArrayList<Integer> getRows(List<Integer> perRow, int rowNum) {
        ArrayList<Integer> row = new ArrayList();
        row.add(1);
        for (int i = 0; i < perRow.size() - 1; i++) {
            row.add(perRow.get(i) + perRow.get(i + 1));
        }
        if (rowNum > 0) {
            row.add(1);
        }
        return row;
    }
}