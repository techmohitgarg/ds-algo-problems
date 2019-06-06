package com.mohit.strings.easy;
/*
https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome main = new ValidPalindrome();
        System.out.println(main.isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();
        while (left <= right) {
            char m = s.charAt(left);
            char n = s.charAt(right);
            if (!Character.isLetterOrDigit(m)) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(n)) {
                right--;
                continue;
            }
            if (m == n) {
                left++;
                right--;
            } else {
                return false;
            }

        }
        return true;
    }

}
