package com.mohit.stacks.leetcode;

import java.util.Stack;

public class DecodedString {

    public static void main(String[] args) {
        DecodedString string = new DecodedString();
        System.out.println(string.decodeString("2[abc]3[cd]ef"));
    }

    public String decodeString(String s) {
        if (s.length() == 0) {
            return s;
        }
        Stack<Integer> num = new Stack<>();
        Stack<String> values = new Stack<>();
        String current = "";
        char[] ch = s.toCharArray();
        int i = 0;
        while (i < ch.length) {
            char c = ch[i];
            if (Character.isDigit(c)) {
                int val = 0;
                while (i < ch.length && Character.isDigit(ch[i])) {
                    val = 10 * val + (ch[i] - '0');
                    i++;
                }
                num.push(val);
            } else if (Character.isLetter(c)) {
                current += c;
                i++;
            } else if (c == '[') {
                values.push(current);
                current = "";
                i++;
            } else if (c == ']') {
                if (!num.empty()) {
                    int val = num.pop();
                    String temp = "";
                    for (int j = 0; j < val; j++) {
                        temp += current;
                    }
                    if (!values.empty()) {
                        temp = values.pop() + temp;
                    }
                    current = temp;
                }
                i++;
            }
        }

        return current;
    }
}
