package com.mohit.greeksofgreeks.stacks;

import java.util.*;

public class LengthOfLongestValidSubstring {

    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        LengthOfLongestValidSubstring sol = new LengthOfLongestValidSubstring();
        Scanner s = new Scanner(System.in);

    }

    public int lengthOfLongestValidSubstring(String str) {
        if (str.length() == 0) return 0;

        Stack<Integer> st = new Stack<>();

        int i = -1;
        int maxLength = 0;
        // Default value
        st.push(-1);
        while (i < str.length() - 1) {
            char ch = str.charAt(++i);
            if (ch == '(') {
                st.push(i);
            } else {
                st.pop();
                if (!st.isEmpty()) {
                    maxLength = Math.max(maxLength, i - st.peek());
                } else {
                    st.push(i);
                }
            }
        }

        return maxLength;

    }




}