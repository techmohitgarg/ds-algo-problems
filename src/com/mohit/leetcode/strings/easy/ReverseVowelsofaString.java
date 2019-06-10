package com.mohit.leetcode.strings.easy;

public class ReverseVowelsofaString {

    public static void main(String[] args) {
        ReverseVowelsofaString main = new ReverseVowelsofaString();
        System.out.println(main.reverseVowels("hello"));
    }

    public String reverseVowels(String s) {
        if (s.length() == 0) {
            return s;
        }
        char[] ch = s.toCharArray();
        int left = 0;
        int right = ch.length;
        while (left < right) {
            if (isVowels(ch[left]) && isVowels(ch[right])) {
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            } else if (!isVowels(ch[left])) {
                left++;
            } else if (!isVowels(ch[right])) {
                right--;
            }
        }
        return String.valueOf(ch);
    }

    public boolean isVowels(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }
}
