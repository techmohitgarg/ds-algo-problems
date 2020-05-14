package com.mohit.leetcode.stack.hard;


import java.util.Stack;

public class MaximalRectangle {


    public static void main(String[] args) {
        MaximalRectangle sol = new MaximalRectangle();
        char[][] area = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(sol.maximalRectangle(area));
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int maxAreaRectAngle = 0;
        int[] area = new int[matrix[0].length];

        for (char[] ch : matrix) {
            for (int i = 0; i < ch.length; i++) {
                int c = ch[i] - '0';
                // Find the height from top to bottom in the row
                area[i] = (c == 0) ? 0 : area[i] + c;
            }
            // Find the max Area of according to row
            int result = maxArea(area);
            maxAreaRectAngle = Math.max(maxAreaRectAngle, result);
        }
        return maxAreaRectAngle;
    }


    private int maxArea(int[] area) {
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        int i = 0;
        while (i < area.length) {
            while (i < area.length && (st.isEmpty() || (area[st.peek()] <= area[i]))) {
                st.push(i++);
            }
            int top = st.pop();
            maxArea=Math.max(maxArea,(area[top] * ((st.isEmpty() ? i : i - st.peek() - 1))));
        }
        while (!st.isEmpty()) {
            int top = st.pop();
            maxArea=Math.max(maxArea,(area[top] * ((st.isEmpty() ? i : i - st.peek() - 1))));
        }
        return maxArea;
    }
}