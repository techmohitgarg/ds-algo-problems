package com.mohit.leetcode.strings.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/most-common-word/
 */
public class MostCommonWord {

    public static void main(String[] args) {
        MostCommonWord main = new MostCommonWord();
        System.out.println(main.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit","hit"}));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph.length() == 0) {
            return paragraph;
        }



        Set<String> ban = new HashSet<>();
        for (String s : banned) {
            ban.add(s.toLowerCase());
        }

        int max = 0;
        String ans = "";
        HashMap<String, Integer> maxWord = new HashMap<>();
        for (int i = 0; i < paragraph.length(); ) {
            int start = i;
            while (i < paragraph.length() && Character.isLetter(paragraph.charAt(i))) {
                i++;
            }
            String temp = paragraph.substring(start, i).toLowerCase();
            if (!ban.contains(temp)) {
                maxWord.put(temp, maxWord.getOrDefault(temp, 0) + 1);
                if (maxWord.get(temp) > max) {
                    max = maxWord.get(temp);
                    ans = temp;
                }

            }

            while (i < paragraph.length() && !Character.isLetter(paragraph.charAt(i))) {
                i++;
            }
        }
        return ans;
    }


}
