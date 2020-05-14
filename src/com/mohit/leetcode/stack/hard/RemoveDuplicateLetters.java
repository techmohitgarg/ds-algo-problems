package com.mohit.leetcode.stack.hard;


import java.util.HashMap;

public class RemoveDuplicateLetters {


    public static void main(String[] args) {
        RemoveDuplicateLetters sol = new RemoveDuplicateLetters();
        //""
        System.out.println(sol.removeDuplicateLetters1("abacb"));
        System.out.println(sol.removeDuplicateLetters("abacb"));
    }

    public String removeDuplicateLetters1(String s) {
        int[] remaining = new int[26];
        int[] used = new int[26];

        final int L = s.length();
        for (int i = 0; i < L; i++) {
            ++remaining[s.charAt(i) - 'a'];
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < L; i++) {
            char ch = s.charAt(i);
            if (used[ch - 'a'] == 0) {
                // to pop out duplicates and bigger characters
                while (builder.length() > 0
                        && builder.charAt(builder.length() - 1) >= ch
                        && remaining[builder.charAt(builder.length() - 1) - 'a'] > 0) {
                    --used[builder.charAt(builder.length() - 1) - 'a'];
                    builder.deleteCharAt(builder.length() - 1);
                }
                builder.append(ch);
                ++used[ch - 'a'];
            }
            --remaining[ch - 'a'];
        }

        return builder.toString();
    }

    public String removeDuplicateLetters(String s) {
        if (s.length() == 0) return s;

        HashMap<Character, Integer> hm = new HashMap<>();
        int[] used = new int[26];
        for (char ch : s.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (used[ch - 'a'] == 0) {
                while (sb.length() > 0
                        && sb.charAt(sb.length() - 1) >= ch
                        && hm.get(sb.charAt(sb.length() - 1)) > 0) {
                    --used[sb.length() - 1 - 'a'];
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append(ch);
                ++used[ch - 'a'];
            }
            hm.put(ch, hm.get(ch) - 1);
            i++;
        }
        return sb.toString();
    }


}