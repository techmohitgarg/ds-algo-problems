package com.mohit.interviewbit.stack;

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallerElement {

    public static void main(String[] args) {
        int[] num = {3, 2, 1};
        ArrayList<Integer> integers = new ArrayList<>();
        for (int n : num) {
            integers.add(n);
        }
        System.out.println(new NearestSmallerElement().prevSmaller(integers));
    }

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            result.add(-1);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = A.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A.get(stack.peek()) > A.get(i)) {
                result.set(stack.peek(), A.get(i));
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}

