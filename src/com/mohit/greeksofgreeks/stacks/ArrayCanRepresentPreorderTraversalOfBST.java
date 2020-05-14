package com.mohit.greeksofgreeks.stacks;

import java.util.Stack;

public class ArrayCanRepresentPreorderTraversalOfBST {

    public static void main(String[] args) {
        ArrayCanRepresentPreorderTraversalOfBST sol = new ArrayCanRepresentPreorderTraversalOfBST();
        int[] nums = {2, 4, 1};
        System.out.println(sol.canRepresentBST(nums, nums.length));
    }


    boolean canRepresentBST(int pre[], int n) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MIN_VALUE;
        int i = 0;
        while (i < n) {
            if (pre[i] < root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() < pre[i]) {
                root = stack.pop();
            }

            stack.push(pre[i]);
            i++;
        }

        return true;
    }


}