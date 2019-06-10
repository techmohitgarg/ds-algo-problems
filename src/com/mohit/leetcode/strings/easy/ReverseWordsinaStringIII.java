package com.mohit.leetcode.strings.easy;

/*
https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */
public class ReverseWordsinaStringIII {

    public static void main(String[] args) {
        ReverseWordsinaStringIII main = new ReverseWordsinaStringIII();
        System.out.println(main.reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        if (s.length() == 0) {
            return s;
        }
        char[] ch = s.toCharArray();
        int n = ch.length;
        for (int i = 0; i < n;) {
            while (i < n && ch[i] == ' ') {
                i++;
            }
            int start = i;
            while (i < n && ch[i] != ' ') {
                i++;
            }
            reverse(ch, start, i - 1);
        }
        return String.valueOf(ch);
    }

    private void reverse(char[] ch, int l, int r) {
        while (l < r) {
            char temp = ch[l];
            ch[l] = ch[r];
            ch[r] = temp;
            l++;
            r--;
        }
    }
}
