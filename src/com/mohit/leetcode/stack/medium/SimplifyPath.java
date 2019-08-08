/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.leetcode.stack.medium;

import java.util.Stack;

/**
 * @author Mohit Garg
 */
public class SimplifyPath {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimplifyPath problems = new SimplifyPath();
        System.out.println(problems.simplifyPath("/a//b////c/d//././/.."));

    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < path.length(); i++) {
            int start = i;
            while (i < path.length() && path.charAt(i) != '/') {
                i++;
            }
            String value = path.substring(start, i);
            if (value.equals("/")) {
            } else if (value.equals(".")) {
            } else if (value.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (value.length() == 0) {
            } else {
                stack.push(value);
            }
        }
        String value = "";
        while (!stack.isEmpty()) {
            String temp = stack.pop();
            value = ("/" + temp) + value;
        }
        return value.length() > 0 ? value : "/";
    }
}
