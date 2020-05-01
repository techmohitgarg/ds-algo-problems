package com.mohit.greeksofgreeks.stacks;

import java.util.Stack;

public class PrintNextGreaterNumberofQqueries {
    public static void main(String[] args) {
        PrintNextGreaterNumberofQqueries sol = new PrintNextGreaterNumberofQqueries();
        int[] nums = {3, 4, 2, 7, 5, 8, 10,};
        int[] queries = {3, 6, 1};
        sol.getAllNextGreaterNumber(nums, queries);
    }


    private void getAllNextGreaterNumber(int[] nums, int[] queries) {
        Stack<Integer> st = new Stack<>();
        int[] nextNum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                nextNum[st.pop()] = nums[i];
            }
            st.push(i);
        }

        while (!st.isEmpty())
            nextNum[st.pop()] = -1;



        for (int i = 0; i < queries.length; i++) {
            System.out.printf(nextNum[queries[i]] + " ");
        }

    }


}