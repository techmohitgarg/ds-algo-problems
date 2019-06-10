package com.mohit.leetcode.strings.easy;

/*
https://leetcode.com/problems/repeated-string-match/
 */
public class RepeatedStringMatch {

    public static void main(String[] args) {
        RepeatedStringMatch main = new RepeatedStringMatch();
        System.out.println(main.repeatedStringMatch("abcabcabcabc", "abac"));
    }

    public int repeatedStringMatch(String A, String B) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < B.length()) {
            count++;
            sb.append(A);
        }
        if (!sb.toString().contains(B)) {
            count++;
            sb.append(A);
        }
        if (!sb.toString().contains(B)) {
            return -1;
        }
        return count;
    }
}
