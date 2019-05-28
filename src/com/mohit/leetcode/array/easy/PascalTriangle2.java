package com.mohit.leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it.

Input: 3
Output: [1,3,3,1]

Link : https://leetcode.com/problems/pascals-triangle-ii/description/
*/

public class PascalTriangle2 {
    public static void main(String[] args) {
        PascalTriangle2 pt = new PascalTriangle2();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(5);
        A.add(10);
        A.add(2);
        A.add(1);
        ArrayList<Integer> B = pt.performOps(A);
        for (int i = 0; i < B.size(); i++) {
            System.out.print(B.get(i) + " ");
        }
    }

    ArrayList<Integer> performOps(ArrayList<Integer> A) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        for (int i = 0; i < 2 * A.size(); i++) B.add(0);

        for (int i = 0; i < A.size(); i++) {
            B.set(i, A.get(i));
            B.set(i + A.size(), A.get((A.size() - i) % A.size()));
        }
        return B;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList();
        for (int i = 0; i <= rowIndex; i++) {
            row = getRows(row, i);
        }
        return row;
    }

    public List<Integer> getRows(List<Integer> perRow, int rowNum) {
        List<Integer> row = new ArrayList();
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