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
public class NumDecodings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NumDecodings problems = new NumDecodings();
        System.out.println(problems.numDecodings("10"));
    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0' || s.length() == 0) {
            return 0;
        }
        int[] count = new int[s.length() + 1];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i < count.length; i++) {
            count[i] = 0;
            if (s.charAt(i - 1) > '0') {
                count[i] = count[i - 1];
            }

            if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7') {
                count[i] += count[i - 2];
            }
        }
        return count[count.length - 1];
    }

    public int numDecodings(char[] s, int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int count = 0;

        if (s[n - 1] <= '9') {
            count = numDecodings(s, n - 1);
        }

        if (s[n - 2] == '1' || s[n - 2] == '2' && s[n - 1] < '7') {
            count += numDecodings(s, n - 2);
        }
        return count;
    }

}
