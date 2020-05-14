package com.mohit.leetcode.stack;


import java.util.*;

public class PrevSmallProblem {


    public static void main(String[] args) {
        PrevSmallProblem sol = new PrevSmallProblem();
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = {1, 3, 1, 2, 0, 5};
        for (int a : arr) {
            list.add(a);
        }
        sol.prevSmaller(list);

    }


    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A.size() == 0) return result;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.size(); i++) {
            while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result.add(-1);
            } else {
                result.add(A.get(stack.peek()));
            }
            stack.add(i);
        }
        return result;
    }


}