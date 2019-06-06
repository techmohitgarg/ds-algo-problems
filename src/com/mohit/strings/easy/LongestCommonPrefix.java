package com.mohit.strings.easy;

/*
https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix main = new LongestCommonPrefix();
        System.out.println(main.longestCommonPrefix(new String[]{"aa", "a"}));
    }

    //Divide and conquer Approach
    public String longestCommonPrefix(String[] strs) {
        return commanString(strs, 0, strs.length - 1);
    }

    public String commanString(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }
        if (left < right) {
            int mid = (right + left) / 2;
            String leftPart = commanString(strs, left, mid );
            String rightPart = commanString(strs, mid + 1, right);
            return comman(leftPart, rightPart);
        }
        return "";
    }

    public String comman(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }

    /*public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }*/

    /*public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            boolean isMatch = true;
            int j;
            for (j = 1; j < strs.length; j++) {
                if (i >= strs[j].length()) {
                    isMatch = false;
                    break;
                }
                if (c != strs[j].charAt(i)) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                sb.append(c);
            } else {
                return sb.toString();
            }
        }
        return sb.toString();
    }*/


}
