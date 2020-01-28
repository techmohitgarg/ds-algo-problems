/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.leetcode.strings.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mohit Garg
 */
public class GenerateParentheses {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GenerateParentheses problems = new GenerateParentheses();
        System.out.println(problems.generateParenthesis(5));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        geteParenthesis(list, "", 0, 0, n);
        return list;
    }

    public void geteParenthesis(List<String> list, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }
        if (open < max) {
            geteParenthesis(list, str + "(", open + 1, close, max);
        }
        if (close < open) {
            geteParenthesis(list, str + ")", open, close + 1, max);
        }
    }

}
