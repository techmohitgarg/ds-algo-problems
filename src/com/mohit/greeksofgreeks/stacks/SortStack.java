package com.mohit.greeksofgreeks.stacks;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        SortStack stack = new SortStack();
        Stack<Integer> integers = new Stack<>();
        integers.push(1);
        integers.push(3);
        integers.push(10);
        integers.push(2);
        integers.push(4);
        integers.push(19);
        stack.sort(integers);
    }

    public void sort(Stack<Integer> stack) {
        Stack<Integer> rstk = new Stack<>();
        while (!stack.empty()) {
            int temp = stack.pop();
            while (!rstk.empty() && rstk.peek() > temp) {
                stack.push(rstk.pop());
            }
            rstk.push(temp);
        }
        System.out.println(rstk);
    }
}
