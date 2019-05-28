package com.mohit.stacks.leetcode;

import java.util.Stack;

public class BackspaceStringCompare {

    public static void main(String[] args) {

    }


    public boolean backspaceCompare(String S, String T) {
        int sLen = S.length();
        int tLen = T.length();
        if (sLen == 0 && tLen == 0) {
            return false;
        }
        //"ab#c", T = "ad#c"
        //"ab##", T = "c#d#"
        //"a##c", T = "#a#c"
        char[] sh = S.toCharArray();
        char[] th = T.toCharArray();

        Stack<Character> backSpace = new Stack<>();
        Stack<Character> values = new Stack<>();

        return false;
    }

}
