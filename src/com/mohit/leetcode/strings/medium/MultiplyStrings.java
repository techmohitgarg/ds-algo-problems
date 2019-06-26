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
public class MultiplyStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MultiplyStrings problems = new MultiplyStrings();
        System.out.println(problems.multiply("9", "9"));
    }

    public String multiply(String num1, String num2) {

        if (num1.length() == 0 & num2.length() == 0) {
            return "";
        }
        if (num1.length() == 0) {
            return num2;
        }
        if (num2.length() == 0) {
            return num1;
        }
        int[] multi = new int[num1.length() + num2.length()];
        int m = 0;

        for (int i = num1.length() - 1; i >= 0; i--) {
            int carry = 0;
            int a = num1.charAt(i) - '0';
            int n = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int sum = (a * b) + carry + multi[m + n];
                multi[m + n] = sum % 10;
                carry = sum / 10;
                n++;
            }
            if (carry > 0) {
                multi[m + n] = carry;
            }
            m++;
        }

        StringBuilder sb = new StringBuilder();
        int i = multi.length - 1;
        while (i > 0 && multi[i] == 0) {
            i--;
        }
        while (i >= 0) {
            sb.append(multi[i]);
            i--;
        }
        return sb.toString();
    }

}
