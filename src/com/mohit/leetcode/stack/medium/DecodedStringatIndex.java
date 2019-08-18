package com.mohit.leetcode.stack.medium;

public class DecodedStringatIndex {
    public static void main(String[] args) {
        //"y959q969u3hb22odq595"
        //222280369
        System.out.println(new DecodedStringatIndex().decodeAtIndex("leet2code3", 10));
    }

    public String decodeAtIndex(String S, int K) {
        long size = 0;
        int N = S.length();

        for (int i = 0; i < N; ++i) {
            char c = S.charAt(i);
            if (Character.isDigit(c))
                size *= c - '0';
            else
                size++;
        }

        for (int i = N - 1; i >= 0; --i) {
            char c = S.charAt(i);
            K %= size;
            if (K == 0 && Character.isLetter(c))
                return Character.toString(c);

            if (Character.isDigit(c))
                size /= c - '0';
            else
                size--;
        }

        throw null;
    }
}