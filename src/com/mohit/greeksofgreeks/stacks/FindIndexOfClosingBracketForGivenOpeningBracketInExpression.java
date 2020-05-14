package com.mohit.greeksofgreeks.stacks;

import java.util.Stack;

public class FindIndexOfClosingBracketForGivenOpeningBracketInExpression {

    public static void main(String[] args) {
        FindIndexOfClosingBracketForGivenOpeningBracketInExpression sol = new FindIndexOfClosingBracketForGivenOpeningBracketInExpression();
        sol.findClosingIndexOfGivenIndex("[ABC[23]][89]", 0);
        sol.findClosingIndexOfGivenIndex("[ABC[23]][89]", 4);
        sol.findClosingIndexOfGivenIndex("[ABC[23]][89]", 9);
        sol.findClosingIndexOfGivenIndex("[ABC[23]][89]", 1);
    }
    void findClosingIndexOfGivenIndex(String expression, int index) {
        if (expression.length() == 0) return;
        if (expression.length() <= index || expression.charAt(index) != '[') {
            System.out.println("No matching bracket");
            return;
        }
        Stack<Integer> st = new Stack<>();
        int i = 0;
        while (i < expression.length()) {
            if (expression.charAt(i) == '[') {
                st.push(i);
            } else if (expression.charAt(i) == ']') {
                if (st.empty()) {
                    System.out.println("No matching bracket");
                    return;
                }
                if (!st.empty() && st.peek() == index) {
                    System.out.println("losing bracket at index " + i);
                    return;
                }
                st.pop();
            }
            i++;
        }

        if (st.empty()) {
            System.out.println("No matching bracket");
        }

    }


}