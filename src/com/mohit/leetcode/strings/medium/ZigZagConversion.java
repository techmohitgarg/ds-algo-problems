/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.leetcode.strings.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mohit Garg
 */
public class ZigZagConversion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ZigZagConversion problems = new ZigZagConversion();
        String string = "AB";
        int n = 1;
        System.out.println(problems.convert(string, n));
    }

    public String convert(String s, int numRows) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add("");
        }
        if (numRows == 1) {
            return s;
        }
        int row = 0;
        boolean up = false;
        for (int i = 0; i < s.length(); i++) {
            list.set(row, list.get(row) + s.charAt(i));
            if (up) {
                row--;
            } else {
                row++;
            }
            if (row == (numRows - 1)) {
                up = true;
            }
            if (row == 0) {
                up = false;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String string : list) {
            sb.append(string);
        }
        return sb.toString();
    }

}
