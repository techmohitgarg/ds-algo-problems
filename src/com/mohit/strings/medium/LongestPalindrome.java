/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.strings.medium;

import java.util.HashMap;

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
    }
}
