package com.mohit.leetcode.strings.easy;

public class FirstUniqueCharacterinString {

    public static void main(String[] args) {
        FirstUniqueCharacterinString main = new FirstUniqueCharacterinString();
        System.out.println(main.firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        if (s.length() == 0) {
            return -1;
        }

        int[] ch = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ch[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (ch[s.charAt(i) - 'a'] == 1) {
                return i;
            }

        }
        return -1;
    }
}
