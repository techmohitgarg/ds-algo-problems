package com.mohit.leetcode.strings.easy;

/*
https://leetcode.com/problems/to-lower-case/submissions/
 */
public class ToLowerCase {

    public static void main(String[] args) {
        ToLowerCase main = new ToLowerCase();
        System.out.println(main.toLowerCase("Hello"));
    }

    public String toLowerCase(String str) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 'A' && ch[i] <= 'Z') {
                ch[i] = (char) ((ch[i]) + 32);
            }
        }
        return String.valueOf(ch);
    }
}
