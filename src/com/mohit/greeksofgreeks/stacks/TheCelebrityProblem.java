package com.mohit.greeksofgreeks.stacks;

import java.util.Stack;

public class TheCelebrityProblem {

    public static void main(String[] args) {
        System.out.println(new TheCelebrityProblem().isCelebrity(4));
    }


    public boolean isknows(int a, int b) {
        int MATRIX[][] = {{0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}};
        return MATRIX[a][b] == 1;
    }

    public int isCelebrity(int n) {
        int celebrity = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            stack.push(isknows(a, b) ? b : a);
        }

        celebrity = stack.pop();
        for (int i = 0; i < n; i++) {
            if (celebrity != i && (!isknows(i, celebrity) || isknows(celebrity, i))) {
                return -1;
            }
        }
        return celebrity;
    }


}

