package com.mohit.leetcode.queue;


import java.util.*;

public class SlidingWindowMaximum {


    public static void main(String[] args) {
        SlidingWindowMaximum sol = new SlidingWindowMaximum();
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = {1, 3, 1, 2, 0, 5};
        sol.maxSlidingWindow(arr, 3);

    }

    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A.size() == 0 || B <= 1) return result;

        Deque<Integer> deque = new LinkedList<>();
        int i = 0;
        int start = 0;
        while (i < A.size()) {
            if (i < B) {
                while (!deque.isEmpty() && A.get(deque.getLast())<A.get(i)) {
                    deque.removeLast();
                }
                deque.addLast(i);
            } else {

                //Add the Top Max value in the result array
                result.add(A.get(deque.peek()));

                while (!deque.isEmpty() && deque.getFirst() <= (i - B)) {
                    deque.removeFirst();
                }

                while (!deque.isEmpty() && A.get(deque.getLast())<A.get(i)) {
                    deque.removeLast();
                }
                deque.addLast(i);
            }
            i++;
        }

        result.add(A.get(deque.peek()));

        return result;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k <= 1) return nums;
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int i = 0;
        int start = 0;
        while (i < nums.length) {
            if (i < k) {
                while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                    deque.removeLast();
                }
                deque.addLast(i);
            } else {

                //Add the Top Max value in the result array
                result[start] = nums[deque.peek()];
                start++;

                while (!deque.isEmpty() && deque.getFirst() <= (i - k)) {
                    deque.removeFirst();
                }

                while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                    deque.removeLast();
                }
                deque.addLast(i);
            }
            i++;
        }
        if (start < result.length) {
            result[start] = nums[deque.peek()];
        }
        return result;
    }


}