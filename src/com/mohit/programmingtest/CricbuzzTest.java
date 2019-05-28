package com.mohit.programmingtest;

import java.util.Stack;

public class CricbuzzTest {
    public static void main(String[] args) {
        int arr[] = {7, 2, 6, 4};
        int n = arr.length;
        System.out.println(maxDifference(arr));
    }

    static int maxDifference(int[] a) {
        int min = a[0];
        int maxDiff = -1;

        for (int i = 1; i < a.length; i++) {
            if (a[i] > min) {
                maxDiff = a[i] - min > maxDiff ? (a[i] - min) : maxDiff;
            } else {
                min = a[i];
            }
        }

        return maxDiff;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        if (ch.length == 1) {
            return false;
        }
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
                continue;
            }
            if (!stack.isEmpty()) {
                char start = stack.pop();
                if (!isMatch(start, c)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    private static boolean isMatch(char start, char end) {
        if (start == '{' && end == '}' || start == '[' && end == ']' || start == '(' && end == ')') {
            return true;
        }
        return false;
    }
}
