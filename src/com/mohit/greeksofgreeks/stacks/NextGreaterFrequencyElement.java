package com.mohit.greeksofgreeks.stacks;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterFrequencyElement {
    public static void main(String[] args) {

        new NextGreaterFrequencyElement().nextGreaterFrequencyElement(new int[]{1, 1, 2, 3, 4, 2, 1});
    }
    // Next Greater Frequency Element


    public void nextGreaterFrequencyElement(int[] arr) {
        // Find the List of All the number frequency in the array

        HashMap<Integer, Integer> mapFreq = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            mapFreq.put(arr[i], mapFreq.getOrDefault(arr[i], 0) + 1);
        }
        System.out.println(mapFreq);
        // Find the next Greater Frequency Number
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            result[i] = -1;
            while (!stack.isEmpty() && mapFreq.get(arr[stack.peek()]) < mapFreq.get(arr[i])) {
                result[stack.peek()] = arr[i];
                stack.pop();
            }
            stack.push(i);
        }
    }


}