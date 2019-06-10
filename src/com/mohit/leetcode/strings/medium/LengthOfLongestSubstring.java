/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.leetcode.strings.medium;

import java.util.HashMap;

/**
 *
 * @author Mohit Garg
 */
public class LengthOfLongestSubstring {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LengthOfLongestSubstring problems = new LengthOfLongestSubstring();
        String string = "abcabcbb";
        System.out.println(problems.lengthOfLongestSubstringUsingHashMap(string));
        System.out.println(problems.lengthOfLongestSubstringUsingArray(string));
    }

    //region Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstringUsingHashMap(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 0;
        int j = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i))) {
                j = Math.max(hm.get(s.charAt(i)), j);
            }
            max = Math.max(max, i - j + 1);
            hm.put(s.charAt(i), i + 1);

        }
        return max;
    }

    public int lengthOfLongestSubstringUsingArray(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 0;
        int j = 0;
        int[] num = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            if (num[val] != 0) {
                j = Math.max(num[val], j);
            }
            max = Math.max(max, i - j + 1);
            num[val] = i + 1;
        }
        return max;
    }
    //endregion
}
