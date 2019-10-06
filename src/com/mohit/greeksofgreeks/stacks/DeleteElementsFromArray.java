package com.mohit.greeksofgreeks.stacks;

import java.util.Stack;

public class DeleteElementsFromArray {

    public static void main(String[] args) {
        int[] num = {23, 45, 11, 77, 18};
        Stack<Integer> s = new Stack<>();
        for (int val : num) {
            s.push(val);
        }
        new DeleteElementsFromArray().deleteElementFromArray(num, 3);
    }

    public void deleteElementFromArray(int[] arr, int k) {
        Stack<Integer> stack = new Stack<>();
        int i = -1;
        while (++i < arr.length) {
            // Delete the top element from stack if top element is less than current element
            while (!stack.isEmpty() && k > 0 && stack.peek() < arr[i]) {
                stack.pop();
                k--;
            }
            // Push the element in stack
            stack.push(arr[i]);
        }
        System.out.println(stack);
    }

}

