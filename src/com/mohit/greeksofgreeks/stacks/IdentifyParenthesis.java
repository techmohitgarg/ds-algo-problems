package com.mohit.greeksofgreeks.stacks;

import java.util.*;

public class IdentifyParenthesis {


    public static void main(String[] args) {
        IdentifyParenthesis sol = new IdentifyParenthesis();
        Scanner s = new Scanner(System.in);
        sol.identifyParenthesis("(((abc))))((d)))(()()");
    }


    public void identifyParenthesis(String sb) {
        Stack<Integer> st = new Stack<>();
        StringBuilder a = new StringBuilder(sb);
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '(')
                st.push(i);
            else if (a.charAt(i) == ')') {
                if (st.empty())
                    a.replace(i, i + 1, "-1");

                else {
                    a.replace(i, i + 1, "1");
                    a.replace(st.peek(), st.peek() + 1, "0");
                    st.pop();
                }
            }
        }
        while (!st.isEmpty()) {
            a.replace(st.peek(), 1, "-1");
            st.pop();
        }

        System.out.println(a.toString());
    }
}