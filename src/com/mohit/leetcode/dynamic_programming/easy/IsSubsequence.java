package com.mohit.leetcode.dynamic_programming.easy;

public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("abc", ""));
    }


    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int j = 0;
        for (int i = 0; i < tLen && j < sLen; i++) {
            if (s.charAt(j) == t.charAt(i)) {
                j++;
            }
        }
        if (j == sLen) return true;
        return false;
    }

}