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
public class DeleteOperationforTwoStrings {

    public static void main(String[] args) {
        DeleteOperationforTwoStrings problems = new DeleteOperationforTwoStrings();
        String word1 = "sea";
        String word2 = "ate";
        System.out.println(problems.minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        if (n1 == 0 && n2 == 0) {
            return 0;
        }
        if (n1 == 0) {
            return n2;
        }
        if (n2 == 0) {
            return n1;
        }
        int[][] temp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                } else {
                    temp[i][j] = Math.max(temp[i - 1][j], temp[i][j - 1]);
                }
            }
        }

        int lcs = temp[n1][n2];
        int count = (n1 - lcs) + (n2 - lcs);
        return count;
    }
}
