package com.mohit.strings.easy;

/*
https://leetcode.com/problems/implement-strstr/
 */
public class ImplementstrStr {

    public static void main(String[] args) {
        ImplementstrStr main = new ImplementstrStr();
        System.out.println(main.strStr("aabaaabaaac", ""));
    }

    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() != 0) return -1;
        if (haystack.length() == 0 && needle.length() == 0) return 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length()) {
                return -1;
            }
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
    /*public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int nextMatchIntex = -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int start = i;
                int j = 0;
                while (start < haystack.length() && j < needle.length() && haystack.charAt(start) == needle.charAt(j)) {
                    if (nextMatchIntex == -1 && i != start && haystack.charAt(start) == needle.charAt(0)) {
                        nextMatchIntex = start;
                    }
                    start++;
                    j++;
                }
                if (j == needle.length()) {
                    return i;
                }
                if (nextMatchIntex != start && nextMatchIntex > i) {
                    i = nextMatchIntex - 1;
                }
            }
        }
        return -1;
    }*/

}
