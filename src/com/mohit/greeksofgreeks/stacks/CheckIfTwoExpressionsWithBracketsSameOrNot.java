package com.mohit.greeksofgreeks.stacks;

import java.util.Scanner;
import java.util.Stack;

public class CheckIfTwoExpressionsWithBracketsSameOrNot {

    public static void main(String[] args) {
        CheckIfTwoExpressionsWithBracketsSameOrNot sol = new CheckIfTwoExpressionsWithBracketsSameOrNot();
        Scanner s = new Scanner(System.in);
        sol.areSame("-(a+b+c)", "-a-b-c");
    }

    public boolean areSame(String expr1, String expr2) {
        int[] val = new int[26];

        eval(expr1, val, true);
        eval(expr2, val, false);

        for (int i = 0; i < val.length; i++) {
            if (val[i] != 0) return false;
        }
        return true;
    }


    public void eval(String exp, int[] val, boolean add) {
        if (exp.length() == 0) return;

        Stack<Boolean> op = new Stack<>();
        op.push(true);
        int i = 0;
        while (i < exp.length()) {
            if (exp.charAt(i) == '+' || exp.charAt(i) == '-') {
                i++;
                continue;
            } else if (exp.charAt(i) == '(') {
                // Add Sign here
                if (addSign(exp, i)) {
                    op.add(op.peek());
                } else {
                    op.add(!op.peek());
                }
            } else if (exp.charAt(i) == ')') {
                if (!op.isEmpty())
                    op.pop();
            } else {
                // If the Sign is positive means we have to add the number
                if (op.peek()) {
                    val[exp.charAt(i) - 'a'] += addSign(exp, i) ? add ? 1 : -1 : add ? -1 : 1;
                } else {
                    val[exp.charAt(i) - 'a'] += addSign(exp, i) ? add ? -1 : 1 : add ? 1 : -1;
                }
            }

            i++;
        }


    }


    private boolean addSign(String str, int i) {
        if (i == 0) return true;
        else if (str.charAt(i - 1) == '-') return false;
        else return true;
    }

}