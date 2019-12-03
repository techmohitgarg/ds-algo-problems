package com.mohit.leetcode.dynamic_programming.medium;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("ABCBDAB", "BDCABA"));
    }


    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) return 0;
        int[][] sub = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < sub.length; i++) {
            for (int j = 0; j < sub[0].length; j++) {
                if (i == 0 || j == 0) {
                    sub[i][j] = 0;
                } else if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    sub[i][j] = 1 + sub[i - 1][j - 1];
                } else {
                    sub[i][j] = Math.max(sub[i][j - 1], sub[i - 1][j]);
                }
            }
        }
        return sub[text1.length()][text2.length()];
    }

    /*public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequence(text1, text2, 0, 0);
    }

    public int longestCommonSubsequence(String text1, String text2, int i, int j) {
        if (text1.length() <= i || text2.length() <= j) {
            return 0;
        }
        if (text1.charAt(i) == text2.charAt(j)) return 1 + longestCommonSubsequence(text1, text2, i + 1, j + 1);

        return Math.max(longestCommonSubsequence(text1, text2, i + 1, j), longestCommonSubsequence(text1, text2, i, j + 1));
    }*/


}