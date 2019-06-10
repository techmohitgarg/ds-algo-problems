package com.mohit.strings.easy;
/*
https://leetcode.com/problems/repeated-substring-pattern/
 */
public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        RepeatedSubstringPattern main = new RepeatedSubstringPattern();
        System.out.println(main.repeatedSubstringPattern("abaababaab"));
    }

    public boolean repeatedSubstringPattern(String s) {
        int[] arr = new int[s.length()];
        int index = 0;
        for (int i = 1; i < s.length(); ) {
            if (s.charAt(index) == s.charAt(i)) {
                arr[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = arr[index - 1];
                } else {
                    arr[i] = 0;
                    i++;
                }
            }
        }
        if (arr[arr.length - 1] == 0)
            return false;
        int lastSubString = s.length() - arr[arr.length - 1];
        if (arr[arr.length - 1] % lastSubString == 0)
            return true;

        return false;
    }


    /*public boolean repeatedSubstringPattern(String s) {
        for (int i = 0; i < s.length(); i++) {
            String a = s.substring(0, i + 1);
            int j;
            for (j = i + 1; j < s.length() - i; j += i + 1) {
                String b = s.substring(j, j + i + 1);
                if (!a.equals(b)) {
                    break;
                }
                if ((j + i + 1) == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }*/

}
