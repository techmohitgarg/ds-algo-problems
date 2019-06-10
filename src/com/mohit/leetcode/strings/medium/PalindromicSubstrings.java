/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.leetcode.strings.medium;

/**
 *
 * @author Mohit Garg
 */
public class PalindromicSubstrings {

    public static void main(String[] args) {
        PalindromicSubstrings problems = new PalindromicSubstrings();
        System.out.println(problems.countSubstrings("aaa"));
    }

    public int countSubstrings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrom(s, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isPalindrom(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
