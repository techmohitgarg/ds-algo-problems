package com.mohit.leetcode.stack.easy;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {

    public static void main(String[] args) {
        new NextGreaterElementI().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
    }


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<int[]> stack = new Stack<>();
        int i = 0;
        while (i < nums2.length) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()[1]) {
                map.put(stack.peek()[1], nums2[i]);
                stack.pop();
            }
            stack.push(new int[]{i, nums2[i]});
            i++;
        }
        for (int j = 0; j < nums1.length; j++) {
            if (map.containsKey(nums1[j])) {
                nums1[j] = map.get(nums1[j]);
            } else {
                nums1[j] = -1;
            }
        }
        return nums1;
    }
}
