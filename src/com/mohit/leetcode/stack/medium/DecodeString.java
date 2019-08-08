package com.mohit.leetcode.stack.medium;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("2[abc]3[cd]ef"));
    }

    public String decodeString(String s) {
        Stack<String> strings = new Stack<>();
        Stack<Integer> num = new Stack<>();
        String data = "";
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                // Check if num is not equal to 0;
                if (val != 0) {
                    num.push(val);
                    val = 0;
                }
                strings.push(data);
                data = "";

            } else if (c == ']') {
                if (!num.isEmpty()) {
                    int count = num.pop();
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < count; j++) {
                        sb.append(data);
                    }
                    data = strings.isEmpty() ? sb.toString() : strings.pop() + sb.toString();
                }

            } else if (c >= '0' && c <= '9') {
                val = val * 10 + (c - '0');
            } else {
                data += c;
            }
        }
        return data;
    }
}