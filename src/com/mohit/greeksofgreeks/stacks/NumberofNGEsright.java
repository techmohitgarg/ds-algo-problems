package com.mohit.greeksofgreeks.stacks;

import java.util.HashMap;
import java.util.Stack;

public class NumberofNGEsright {

    public static void main(String[] args) {
        new NumberofNGEsright().numberNGERight(new int[]{3, 4, 2, 7, 5, 8, 10, 6});
    }

    //Number of NGEs to the right
    public void numberNGERight(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int i = 1;
        // Find ALl the next greater elements
        int[] NGE = new int[arr.length];
        stack.push(0);
        while (i < arr.length) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                NGE[stack.pop()] = i;
            }
            stack.push(i);
            i++;
        }
        // Add all -1 value for remaining value
        while (!stack.isEmpty()) {
            NGE[stack.pop()] = -1;
        }

        // Find ALl next greater number count
        int[] dp = new int[arr.length];
        for (int j = arr.length - 2; j >= 0; j--) {
            dp[j] = NGE[j] == -1 ? 0 : 1 + dp[NGE[j]];
        }


    }
    /*private void fillNext(int[] arr, int n, int[] query) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                map.put(stack.peek(), i);
                stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            map.put(stack.peek(), -1);
            stack.pop();
        }
        for (int i = 0; i < query.length; i++) {

            int count = 0;
            int index = query[i];
            while (map.get(index) != -1) {
                count++;
                index = map.get(index);
            }
            System.out.println(count);
        }
    }*/

}