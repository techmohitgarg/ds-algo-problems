package com.mohit.leetcode.strings.easy;

public class RansomNote {

    public static void main(String[] args) {
        RansomNote main = new RansomNote();
        System.out.println(main.canConstruct("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (char c : magazine.toCharArray()) {
            arr[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if ((--arr[c - 'a']) < 0) return false;
        }
        return true;
    }

    /*public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magM = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            if (!magM.containsKey(c)) {
                magM.put(c, 1);
            } else {
                magM.put(c, magM.get(c) + 1);
            }
        }
        for (char c : ransomNote.toCharArray()) {
            if (!magM.containsKey(c)) {
                return false;
            }
            int newCount = magM.get(c) - 1;
            if (newCount < 0) {
                return false;
            }
            magM.put(c, newCount);
        }
        return true;
    }*/
    /*public boolean canConstruct(String ransomNote, String magazine) {
        return canConst(ransomNote.toCharArray(), magazine.toCharArray(), 0, 0);
    }

    public boolean canConst(char[] ransomNote, char[] magazine, int i, int j) {
        if (j == ransomNote.length) {
            return true;
        }
        if (i >= magazine.length) {
            return false;
        }
        if (ransomNote[j] == magazine[i]) {
            return canConst(ransomNote, magazine, i + 1, j + 1);
        }
        return canConst(ransomNote, magazine, i + 1, j);
    }*/


}
