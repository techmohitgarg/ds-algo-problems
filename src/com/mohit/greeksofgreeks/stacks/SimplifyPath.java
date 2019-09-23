/*
https://leetcode.com/problems/simplify-path/
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
path = "/a/../../b/../c//.//", => "/c"
path = "/a//b////c/d//././/..", => "/a/b/c"

In a UNIX-style file system, a period ('.') refers to the current directory, so it can be ignored in a simplified path. Additionally, a double period ("..") moves up a directory, so it cancels out whatever the last directory was. For more information, look here: https://en.wikipedia.org/wiki/Path_(computing)#Unix_style

Corner Cases:

Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
 */
package com.mohit.greeksofgreeks.stacks;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        SimplifyPath minStack = new SimplifyPath();

    }

    public String simplifyPath(String A) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            int start = i;
            while (i < A.length() && A.charAt(i) != '/') {
                i++;
            }
            String value = A.substring(start, i);
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
