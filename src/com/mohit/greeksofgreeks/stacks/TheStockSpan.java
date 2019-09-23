package com.mohit.greeksofgreeks.stacks;

import java.util.Stack;

public class TheStockSpan {

    public static void main(String[] args) {
        TheStockSpan span = new TheStockSpan();
        int[] in = span.calculateSpanUsingStack(new int[]{10, 4, 5, 90, 120, 80});
        for (int i : in) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    public int[] calculateSpan(int[] num) {
        int[] spams = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            spams[i] = 1;
            int j = i - 1;
            while (j >= 0) {
                if (num[i] > num[j]) {
                    spams[i] += 1;
                }
                j--;
            }
        }
        return spams;
    }


    public int[] calculateSpanUsingStack(int[] num) {
        int[] spams = new int[num.length];
        Stack<Integer> stack = new Stack<>();
        int p = 0;
        for (int i = 0; i < num.length; i++) {
            while (!stack.empty() && num[i] >= num[stack.peek()]) {
                stack.pop();
            }
            spams[i] = stack.empty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        return spams;
    }


}
