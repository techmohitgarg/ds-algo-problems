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
public class StringtoInteger {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StringtoInteger problems = new StringtoInteger();
        String string = "+";
        System.out.println(problems.myAtoi(string));
    }

    public int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        if (Character.isLetter(str.charAt(0))) {
            return 0;
        }

        // remove Space
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        while (sb.length() > 0 && sb.charAt(0) == ' ') {
            sb.deleteCharAt(0);
        }
        if (sb.length() == 0) {
            return 0;
        }
        boolean b = false;
        if (sb.charAt(0) == '-' || sb.charAt(0) == '+') {
            b = sb.charAt(0) == '-' ? true : false;
            sb.deleteCharAt(0);
        }
        if (sb.length() == 0) {
            return 0;
        }
        int i = 0;
        int num = 0;
        while (sb.length() > i && Character.isDigit(sb.charAt(i))) {
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && sb.charAt(i) - '0' > 7)) {
                if (b) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            num = (10 * num) + sb.charAt(i) - '0';
            i++;
        }
        return b == true ? (num * -1) : num;
    }

}
