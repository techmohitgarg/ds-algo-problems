package com.mohit.leetcode.dynamic_programming.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"});
        System.out.println(new WordBreak().wordBreak("catsandog", wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            set.add(wordDict.get(i));
        }

        boolean[] data = new boolean[s.length() + 1];
        int len = s.length();
        int i = 0;
        for (i = 0; i <= len; i++) {
            // check if prefix contains in the dictionary
            if (!data[i] && set.contains(s.substring(0, i))) {
                data[i] = true;
            }
            if (data[i]) {
                for (int j = i + 1; j <= len; j++) {
                    if (!data[j] && set.contains(s.substring(i, i + (j - i)))) {
                        data[j] = true;
                    }
                    if (j == len && data[j]) {
                        return true;
                    }
                }
            }
            // in case of if above condition is false so than check with i
            if (i == len && data[i]) {
                return true;
            }
        }

        return false;
    }

    /*public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            set.add(wordDict.get(i));
        }
        return wordBreak(s, set);
    }

    public boolean wordBreak(String s, HashSet<String> set) {
        int size = s.length();
        if (size == 0) return true;
        for (int i = 0; i <= size; i++) {
            if (set.contains(s.substring(0, i)) && wordBreak(s.substring(i, size),set))
                return true;
        }
        return false;
    }*/

}