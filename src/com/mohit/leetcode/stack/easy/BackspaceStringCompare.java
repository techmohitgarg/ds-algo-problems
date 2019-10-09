package com.mohit.leetcode.stack.easy;

import java.util.Stack;

public class BackspaceStringCompare {

    public static void main(String[] args) {
        System.out.println(new BackspaceStringCompare().backspaceCompare("a#c", "c"));
    }
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (TreeBookPractice)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(TreeBookPractice)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }

    public boolean backspaceCompare1(String S, String T) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        // Remove all backspace form S
        int i = 0;
        while (i < S.length()) {
            char c = S.charAt(i);
            if (c >= 'a' && c <= 'z') {
                s1.push(c);
            } else {
                if (!s1.isEmpty()) {
                    s1.pop();
                }
            }
            i++;
        }
        // Remove all backspace from TreeBookPractice
        i = 0;
        while (i < T.length()) {
            char c = T.charAt(i);
            if (c >= 'a' && c <= 'z') {
                s2.push(c);
            } else {
                if (!s2.isEmpty()) {
                    s2.pop();
                }
            }
            i++;
        }

        /*//Check if both stack do'nt have equal length
        if (s1.size() != s2.size()) {
            return false;
        }*/
        if(s1.equals(s2))return true;
        /*while (!s1.isEmpty() && !s2.isEmpty() && s1.peek() == s2.peek()) {
            s1.pop();
            s2.pop();
        }
        if (s1.isEmpty() && s2.isEmpty()) {
            return true;
        }*/
        return false;
    }


}
