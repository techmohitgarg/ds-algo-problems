/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.sorting;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author mohit
 */
public class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram anagram = new ValidAnagram();
        boolean result = anagram.isAnagram("a", "");
        System.out.println(result);
    }

    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i))) {
                hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
            } else {
                hm.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {

            if (hm.get(t.charAt(i)) == null) {
                return false;
            }

            if (hm.get(t.charAt(i)) - 1 < 0) {
                return false;
            }
            hm.put(t.charAt(i), hm.get(t.charAt(i)) - 1);
        }

        return true;
    }
}
