package com.mohit.stacks;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        NextGreaterElement element = new NextGreaterElement();
        int arr[] = {11, 13, 21, 3};
        int n = arr.length;
        element.printNGEUsingStack(arr, n);
        int[] in = element.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4});
        for (int i : in) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // n*n
    public void printNGE(int arr[], int n) {
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            while (j < arr.length && arr[i] > arr[j]) {
                j++;
            }
            if (j < arr.length && arr[i] < arr[j]) {
                System.out.println(arr[i] + "--" + arr[j]);
            } else {
                System.out.println(arr[i] + "--" + -1);
            }
        }
    }

    public void printNGEUsingStack(int arr[], int n) {
        if (n == 0) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        int i = 1;
        while (i < arr.length) {
            int next = arr[i];
            if (stack.empty() == false) {
                int element = stack.pop();
                while (next > element) {
                    System.out.println(element + "-->" + next);
                    if (stack.isEmpty()) {
                        break;
                    }
                    element = stack.pop();
                }
                if (element > next) {
                    stack.push(element);
                }
            }
            stack.push(arr[i]);
            i++;
        }
        while (!stack.empty()) {
            System.out.println(stack.pop() + "-->" + -1);
        }

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if (nums1.length == 0) {
            return nums1;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[0]);
        int i = 1;
        while (i < nums2.length) {
            int next = nums2[i];
            if (stack.empty() == false) {
                int element = stack.pop();
                while (next > element) {
                    map.put(element, next);
                    if (stack.isEmpty()) {
                        break;
                    }
                    element = stack.pop();
                }
                if (element > next) {
                    stack.push(element);
                }
            }
            stack.push(nums2[i]);
            i++;
        }
        while (!stack.empty()) {
            map.put(stack.pop(), -1);
        }

        for (int j = 0; j < nums1.length; j++) {
            nums1[j] = map.get(nums1[j]);
        }
        return nums1;
    }
}
