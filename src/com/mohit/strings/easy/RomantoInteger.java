package com.mohit.strings.easy;

/*
https://leetcode.com/problems/roman-to-integer/
 */
public class RomantoInteger {

    public static void main(String[] args) {
        RomantoInteger main = new RomantoInteger();
        System.out.println(main.romanToInt("MCMXCIV"));
    }


    public int romanToInt(String s) {
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                val = getValue(s.charAt(i));
            } else {
                int curr = getValue(s.charAt(i));
                int last = getValue(s.charAt(i - 1));
                val += (curr > last) ? (curr - last) - last : curr;
            }
        }
        return val;
    }

    public int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

}
