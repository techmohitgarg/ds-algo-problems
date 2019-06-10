package com.mohit.leetcode.strings.easy;

/*
https://leetcode.com/problems/reverse-string-ii/
 */
public class ReverseStringII {

    public static void main(String[] args) {
        ReverseStringII main = new ReverseStringII();
        System.out.println(main.reverseStr("abc", 2));
    }

    public String reverseStr(String s, int k) {
        if (s.length() == 0 || k == 0) {
            return s;
        }
        char[] ch = s.toCharArray();
        int n = ch.length;
        int index = 1;
        for (int i = 0; i < n; i = 2 * k * index, index++) {
            if (ch.length - i < k) {
                reverse(ch, i, ch.length - 1);//(For this condition If there are less than k characters left, reverse all of them)
            } else {
                reverse(ch, i, i + k - 1);
                // (For normal reverse like (2*k moves) and for this condition If there are less than 2k but greater than
                // or equal to k characters, then reverse the first k characters and left the other as original)
            }
        }
        return String.valueOf(ch);
    }


    private void reverse(char[] ch, int l, int r) {
        while (l < r) {
            char temp = ch[l];
            ch[l] = ch[r];
            ch[r] = temp;
            l++;
            r--;
        }
    }

}
