package com.mohit.leetcode.strings.easy;

/*
https://leetcode.com/problems/goat-latin/
 */
public class GoatLatin {

    public static void main(String[] args) {
        GoatLatin main = new GoatLatin();
        System.out.println(main.toGoatLatin("I speak Goat Latin"));
    }


    public String toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            sb.append('a');
            int start = i;
            while (i < S.length() && S.charAt(i) != ' ') {
                i++;
            }
            String temp = S.substring(start, i);
            if (temp.length() > 0) {
                if (isVowels(temp.charAt(0))) {
                    builder.append(temp);
                } else {
                    builder.append(temp.substring(1));
                    builder.append(temp.charAt(0));
                }
                builder.append("ma");
                builder.append(sb);
                if (i != S.length()) {
                    builder.append(" ");
                }

            }
        }
        return builder.toString();
    }

    public boolean isVowels(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }
}
