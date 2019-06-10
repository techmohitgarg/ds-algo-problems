package com.mohit.leetcode.strings.easy;
/*
https://leetcode.com/problems/count-and-say/
 */
public class CountandSay {

    public static void main(String[] args) {
        CountandSay main = new CountandSay();
        System.out.println(main.countAndSay(5));
    }

    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            str = getNextString(str);
        }
        return str;
    }

    private String getNextString(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int i = 0;
        for (i = 0; i < str.length(); ) {
            if (count == 0 || str.charAt(i) == str.charAt(i - count)) {
                count++;
                i++;
            } else {
                sb.append(count);
                sb.append(str.charAt(i - 1));
                count = 0;
            }
        }
        if (count > 0) {
            sb.append(count);
            sb.append(str.charAt(i - 1));
            count = 0;
        }
        return sb.toString();
    }


}
