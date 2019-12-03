/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.leetcode.dynamic_programming.medium;

/**
 *
 * @author Mohit Garg
 */
public class LongestPalindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LongestPalindrome problems = new LongestPalindrome();
        String string = "";
        System.out.println(problems.longestPalindrome(string));
    }

    public String longestPalindrome(String A) {
        if (A.length() == 0) return "";
        int len = A.length();
        boolean[][] palin = new boolean[len][len];


        int maxLength = 0;
        int start = 0;
        // Check for 1 len string
        for (int i = 0; i < len; i++) {
            palin[i][i] = true;
            maxLength = 1;
        }
        // Check for 2 len string
        for (int i = 0; i < len - 1; i++) {
            if (A.charAt(i) == A.charAt(i + 1)) {
                palin[i][i+1] = true;
                maxLength = 2;
                start = i;
            }
        }

        // check for more than 2 char len
        for (int i = 3; i <= len; i++) {

            // Starting from 0 to (i length) means (substring len has to be i)
            for (int j = 0; j < len - i + 1; j++) {
                // Now get the sub String end point
                int k = j + i - 1;

                if (palin[j + 1][k - 1] && A.charAt(j) == A.charAt(k)) {
                    palin[j][k] = true;
                    if (maxLength < i) {
                        maxLength = i;
                        start = j;
                    }
                }
            }

        }
        return A.substring(start, start + maxLength);
    }
  /*  public String longestPalindrome(String A) {
        if (A.length() == 0) {
            return A;
        }
        String vaild = "";
        for (int i = 0; i < A.length(); i++) {
            int j = A.length() - 1;
            if (A.length() <= vaild.length() + i) {
                break;
            }
            while (j >= i) {
                boolean b = isValidPalindrome(A, i, j);
                String temp = A.substring(i, j + 1);
                if (b && vaild.length() < temp.length()) {
                    vaild = temp;
                    break;
                }
                j--;
            }

        }
        return vaild;
 }

    public boolean isValidPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }*/
}
