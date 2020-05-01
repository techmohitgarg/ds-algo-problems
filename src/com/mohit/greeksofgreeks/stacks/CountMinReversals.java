package com.mohit.greeksofgreeks.stacks;

import java.util.*;

public class CountMinReversals {



    public static void main(String[] args) {
        CountMinReversals sol = new CountMinReversals();
        Scanner s = new Scanner(System.in);

    }




    public int countMinReversals(String expr) {
        if (expr.length() == 0 || expr.length() % 2 == 1) {
            return 0;
        }

        int open = 0;
        int close = 0;
        Stack<Character> st = new Stack<>();
        for (char ch : expr.toCharArray()) {
            if (ch == '{') {
                st.push(ch);
            } else {
                if (st.empty()) {
                    close++;
                    continue;
                }
                if (st.peek() != '{') {
                    close++;
                } else {
                    st.pop();
                }

            }
        }
        if (st.isEmpty() && close == 0) return 0;
        open = st.size();
        if (open != 0 && close == 0) {
            return open / 2;
        } else if (open == 0 && close != 0) {
            return close / 2;
        } else {
            int result = ((open / 2)) + ((close / 2)) + (open % 2) + (close % 2);
            return result;
        }
    }



}