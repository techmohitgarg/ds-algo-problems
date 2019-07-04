/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.leetcode.strings.medium;

import java.util.Stack;

/**
 * @author Mohit Garg
 */
public class ValidParenthesisString {

    public static void main(String[] args) {
        ValidParenthesisString problems = new ValidParenthesisString();
        System.out.println(problems.checkValidString("(**)"));
    }

    public boolean checkValidString(String s) {
        int lo = 0;
        int hi = 0;
        for (char c : s.toCharArray()) {
            lo += (c == '(') ? 1 : -1;
            hi += (c != ')') ? 1 : -1;
            if (hi < 0) {
                break;
            }
            lo = Math.max(lo, 0);
        }


        return lo == 0;
    }


    /*public boolean checkValidString(String s) {
        int leftBalance = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == '(') || (s.charAt(i) == '*'))
                leftBalance++;
            else
                leftBalance--;

            if (leftBalance < 0) return false;
        }
        if (leftBalance == 0) return true;
        int rightBalance = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if ((s.charAt(i) == ')') || (s.charAt(i) == '*'))
                rightBalance++;
            else
                rightBalance--;

            if (rightBalance < 0) return false;
        }
        return true;
    }*/
}
