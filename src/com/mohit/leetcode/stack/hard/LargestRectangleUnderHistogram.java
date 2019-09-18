/*
https://leetcode.com/problems/largest-rectangle-in-histogram/
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

The largest rectangle is shown in the shaded area, which has area = 10 unit.

Example:

Input: [2,1,5,6,2,3]
Output: 10
 */

package com.mohit.leetcode.stack.hard;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleUnderHistogram {
    public static void main(String[] args) {
        LargestRectangleUnderHistogram histogram = new LargestRectangleUnderHistogram();
        System.out.println(histogram.largestRectangle(new int[]{1, 1}));
    }

    public int largestRectangle(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max_area = 0;
        int i = 0;
        Stack<Integer> s = new Stack<>();
        while (i < arr.length) {
            if (s.empty() || arr[s.peek()] <= arr[i]) {
                s.push(i++);
            } else {
                int tp = s.peek();
                s.pop();
                max_area = Math.max(max_area, arr[tp] * (s.empty() ? i : i - s.peek() - 1));
            }
        }

        while (!s.empty()) {
            int tp = s.peek();
            s.pop();
            max_area = Math.max(max_area, arr[tp] * (s.empty() ? i : i - s.peek() - 1));
        }
        return max_area;
    }

    public int largestRectangleArea(ArrayList<Integer> A) {
        if (A == null || A.size() == 0) {
            return 0;
        }
        int max_area = 0;
        int i = 0;
        Stack<Integer> s = new Stack<>();
        while (i < A.size()) {
            if (s.empty() || A.get(s.peek()).intValue() <= A.get(i).intValue()) {
                s.push(i++);
            } else {
                int tp = s.peek();
                s.pop();
                max_area = Math.max(max_area, A.get(tp) * (s.empty() ? i : i - s.peek() - 1));
            }
        }

        while (!s.empty()) {
            int tp = s.peek();
            s.pop();
            max_area = Math.max(max_area, A.get(tp) * (s.empty() ? i : i - s.peek() - 1));
        }
        return max_area;
    }

    public int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        int len = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[len];
        int[] right = new int[len];

        for (int i = 0; i < len; i++) {
            right[i] = len;
            left[i] = -1;
        }
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
        }

        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
        }
        return max;
    }
}
