/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.leetcode.strings.medium;

/**
 *
 * @author Mohit Garg
 */
public class NextGreaterElementIII {

    public static void main(String[] args) {
        NextGreaterElementIII bcii = new NextGreaterElementIII();
        System.out.println(bcii.nextGreaterElement(999999));
}

    public int nextGreaterElement(int n) {
        if (n <= 11) {
            return -1;
        }
        String value = String.valueOf(n);
        char[] ch = value.toCharArray();
        int p = ch.length;
        int j = 0;
        for (j = ch.length - 2; j >= 0; j--) {
            if (ch[j] < ch[j + 1]) {
                p = j;
                break;
            }
        }
        if (p == ch.length) {
            return -1;
        }
        int q = ch.length;
        for (j = ch.length - 1; j >= 0; j--) {
            if (ch[j] > ch[p]) {
                q = j;
                break;
            }
        }

        // Inter-change char value
        char temp = ch[p];
        ch[p] = ch[q];
        ch[q] = temp;

        p = p + 1;
        q = ch.length - 1;
        while (p < q) {
            char t = ch[p];
            ch[p] = ch[q];
            ch[q] = t;
            p++;
            q--;
        }
        int nextValue = 0;
        for (char c : ch) {
            if (nextValue > Integer.MAX_VALUE / 10 || (nextValue == Integer.MAX_VALUE / 10 && c > '7')) {
                return -1;
            }
            nextValue = 10 * nextValue + (c - '0');
        }
        return nextValue;
    }
}
