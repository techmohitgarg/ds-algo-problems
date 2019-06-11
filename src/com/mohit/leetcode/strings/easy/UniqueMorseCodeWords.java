package com.mohit.leetcode.strings.easy;

import java.util.HashMap;

/*
https://leetcode.com/problems/unique-morse-code-words/
 */
public class UniqueMorseCodeWords {

    public static void main(String[] args) {
        UniqueMorseCodeWords main = new UniqueMorseCodeWords();
        System.out.println(main.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }

    public int uniqueMorseRepresentations(String[] words) {
        String[] decode = {".-", "-...", "-.-.",
                "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
                ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < words[i].length(); j++) {
                sb.append(decode[words[i].charAt(j) - 'a']);
            }
            map.put(sb.toString(), 1);
        }
        return map.size();
    }
}
