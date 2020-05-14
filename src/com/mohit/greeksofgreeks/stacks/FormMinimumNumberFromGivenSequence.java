package com.mohit.greeksofgreeks.stacks;

import java.util.Stack;

public class FormMinimumNumberFromGivenSequence {

    public static void main(String[] args) {
        FormMinimumNumberFromGivenSequence sol = new FormMinimumNumberFromGivenSequence();
        /*Input: D        Output: 21
        Input: I        Output: 12
        Input: DD       Output: 321
        Input: II       Output: 123
        Input: DIDI     Output: 21435
        Input: IIDDD    Output: 126543
        Input: DDIDDIID Output: 321654798*/
        System.out.println(sol.minNumber("D"));
        System.out.println(sol.minNumber("I"));
        System.out.println(sol.minNumber("DD"));
        System.out.println(sol.minNumber("II"));
        System.out.println(sol.minNumber("DIDI"));
        System.out.println(sol.minNumber("IIDDD"));
        System.out.println(sol.minNumber("DDIDDIID"));
        System.out.println(sol.minNumber("DDDDDDDD"));

    }

//Form minimum number from given sequence

    private int minNumber(String str) {
        if (str.length() == 0) return 0;
        Stack<Integer> st = new Stack<>();
        st.push(1);
        int num = 2;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'I') {
                st.push(num);
            } else {
                Stack<Integer> temp = new Stack<>();
                int prev = i;
                while (!st.empty() && st.peek() < num && str.charAt(prev) == str.charAt(i)) {
                    temp.push(st.pop());
                    prev--;
                }
                st.push(num);
                while (!temp.isEmpty()) {
                    st.push(temp.pop());
                }
            }
            num++;
        }
        int result = 0;
        for (int val : st) {
            result = 10 * result + val;
        }
        return result;
    }

}