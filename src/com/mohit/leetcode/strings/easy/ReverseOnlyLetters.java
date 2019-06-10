package com.mohit.leetcode.strings.easy;

/*
https://leetcode.com/problems/reverse-only-letters/
 */
public class ReverseOnlyLetters {

    public static void main(String[] args) {
        ReverseOnlyLetters main = new ReverseOnlyLetters();
        System.out.println(main.reverseOnlyLetters("ab-cd"));
    }

    public String reverseOnlyLetters(String S) {
        int left = 0;
        int right = S.length() - 1;
        char[] ch = S.toCharArray();
        while (left < right) {
            if (Character.isLetter(ch[left]) &&
                    Character.isLetter(ch[right])) {
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            } else if (!Character.isLetter(ch[left])) {
                left++;
            } else if (!Character.isLetter(ch[right])) {
                right--;
            }
        }
        return String.valueOf(ch);
    }
}
