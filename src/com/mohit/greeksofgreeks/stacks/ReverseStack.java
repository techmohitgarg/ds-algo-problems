package com.mohit.greeksofgreeks.stacks;


import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        ReverseStack stack = new ReverseStack();
        Stack<Integer> integers = new Stack<>();
        integers.push(1);
        integers.push(2);
        integers.push(3);
        integers.push(4);
        stack.reverseStack1(integers);
        System.out.println(integers);
    }


    public void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int val = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, val);
    }

    public void insertAtBottom(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int val = stack.pop();
        insertAtBottom(stack, data);
        stack.push(val);
    }


    private void reverseStack1(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int[] num = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            num[i++] = stack.pop();
        }

        for (int val : num) {
            stack.push(val);
        }
    }
}
