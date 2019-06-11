package com.mohit.leetcode.strings.easy;

/*
https://leetcode.com/problems/buddy-strings/
 */
public class BuddyStrings {

    public static void main(String[] args) {
        BuddyStrings main = new BuddyStrings();
        System.out.println(main.buddyStrings("bc", "cb"));
    }

    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.equals(B)) {
            int[] count = new int[26];
            for (int i = 0; i < A.length(); ++i) {
                int index = A.charAt(i) - 'a';
                count[index]++;
                if (count[index] > 1) {
                    return true;
                }
            }

            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < A.length(); ++i) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (first == -1) {
                        first = i;
                    } else if (second == -1) {
                        second = i;
                    } else {
                        return false;
                    }
                }
            }

            return (second != -1 && A.charAt(first) == B.charAt(second)
                    && A.charAt(second) == B.charAt(first));
        }
    }


}
