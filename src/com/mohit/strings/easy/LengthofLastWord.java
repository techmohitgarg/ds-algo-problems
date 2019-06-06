package com.mohit.strings.easy;

/*
https://leetcode.com/problems/length-of-last-word/
 */
public class LengthofLastWord {

    public static void main(String[] args) {
        LengthofLastWord main = new LengthofLastWord();
        System.out.println(main.lengthOfLastWord("Hello World "));

    }

    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count > 0)
                    return count;
            } else {
                count++;
            }
        }
        return count;
    }

}
