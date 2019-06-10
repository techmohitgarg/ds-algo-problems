package com.mohit.leetcode.strings.medium;

/*
https://leetcode.com/problems/valid-palindrome-ii/
 */
public class ValidPalindromeII {

    public static void main(String[] args) {
        ValidPalindromeII main = new ValidPalindromeII();
        System.out.println(main.validPalindrome("aba"));
    }

    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (isPalindrom(s, left + 1, right) || isPalindrom(s, left, right - 1)) {
                    return true;
                } else {
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrom(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
