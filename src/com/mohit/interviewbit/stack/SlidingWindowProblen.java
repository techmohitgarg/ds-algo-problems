package com.mohit.interviewbit.stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowProblen {

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        ArrayList<Integer> integers = new ArrayList<>();
        for (int n : num) {
            integers.add(n);
        }
        System.out.println(new SlidingWindowProblen().slidingMaximum(integers, 3));
    }

  /*  public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = A.size();
        for (int i = 0; i < n - B + 1; i++) {
            int max = A.get(i);
            for (int j = i; j < i + B; j++) {
                max = Math.max(max, A.get(j));
            }
            result.add(max);
        }
        return result;
    }*/

    // Using Queue
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<Integer>();
        int n = A.size();
        for (int i = 0; i < n; i++) {
            if (i < B) {
                // Remove All the Number which is smaller than current number from Queue
                while (!queue.isEmpty() && A.get(queue.getLast()) <= A.get(i)) {
                    queue.removeLast();
                }
                queue.addLast(i);
            } else {
                // Add the Top Greater Number
                result.add(A.get(queue.peek()));
                // Remove the number which are not in queue
                while (!queue.isEmpty() && queue.peek() <= i - B) {
                    queue.removeFirst();
                }

                // Remove All the Number which is smaller or equal than current number from Queue
                while (!queue.isEmpty() && A.get(queue.getLast()) < A.get(i)) {
                    queue.removeLast();
                }
                queue.addLast(i);
            }
        }
        result.add(A.get(queue.peek()));
        return result;
    }

}

