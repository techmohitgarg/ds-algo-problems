package com.mohit.leetcode.strings;

import java.util.Deque;
import java.util.LinkedList;

public class ReorganizeString {
    public static void main(String[] args) {
        ReorganizeString string = new ReorganizeString();
        System.out.println(string.reorganizeString("cxmwmmm"));
    }

    public String reorganizeString(String s) {
        Deque<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        if (s.length() == 0) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.addLast(c);
            } else {
                if (stack.getLast() != c) {
                    stack.addLast(c);
                    while (sb.length() > 0) {
                        if (stack.peekLast() != sb.charAt(sb.length() - 1)) {
                            stack.addLast(sb.charAt(sb.length() - 1));
                            sb.deleteCharAt(sb.length() - 1);
                        } else if (stack.peekFirst() != sb.charAt(sb.length() - 1)) {
                            stack.addFirst(sb.charAt(sb.length() - 1));
                            sb.deleteCharAt(0);
                        } else {
                            break;
                        }
                    }
                } else {
                    sb.append(c);
                }
            }

        }
        // add remain string
        while (sb.length() > 0) {
            if (stack.peekLast() != sb.charAt(sb.length() - 1)) {
                stack.addLast(sb.charAt(sb.length() - 1));
                sb.deleteCharAt(sb.length() - 1);
            } else if (stack.peekFirst() != sb.charAt(0)) {
                stack.addFirst(sb.charAt(sb.length() - 1));
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        if (sb.length() > 0) {
            return "";
        }

        // check if distinct char exist
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            if (builder.length() == 0) {
                builder.append(stack.pop());
            } else if (stack.peek() != builder.charAt(builder.length() - 1)) {
                builder.append(stack.pop());
            } else {
                return "";
            }

        }

        if (!stack.isEmpty()) {
            return "";
        }
        return builder.toString();
    }
}
