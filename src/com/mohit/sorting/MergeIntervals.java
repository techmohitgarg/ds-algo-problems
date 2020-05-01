/*
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 */
package com.mohit.sorting;

import com.mohit.Solution;

import java.util.*;

/**
 * @author mohit
 */
public class MergeIntervals {

    public static class Interval {

        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "Interval{" + "start=" + start + ", end=" + end + '}';
        }

    }

    public static void main(String[] args) {
        MergeIntervals intervals = new MergeIntervals();
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 4));
        list.add(new Interval(4, 5));
        for (Interval interval : intervals.merge(list)) {
            System.out.println(interval.toString());
        }

    }

    public List<Interval> merge(List<Interval> intervals) {
        int n = intervals.size();
        if (n <= 0) {
            return intervals;
        }
        List<Interval> list = new ArrayList<>();
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int s = 0;
        for (int i = 1; i <= n; i++) {
            if (i == n) {
                list.add(new Interval(start[s], end[i - 1]));
                continue;
            }
            if (end[i - 1] < start[i]) {
                list.add(new Interval(start[s], end[i - 1]));
                s = i;
            }
        }
        return list;
    }

    public void mergeIntervals(Interval arr[]) {
        // Sort Intervals in decreasing order of
        // start time
        Arrays.sort(arr, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i2.start - i1.start;
            }
        });

        int index = 0; // Stores index of last element
        // in output array (modified arr[])

        // Traverse all input Intervals
        for (int i = 1; i < arr.length; i++) {
            // If this is not first Interval and overlaps
            // with the previous one
            if (arr[index].end >= arr[i].start) {
                // Merge previous and current Intervals
                arr[index].end = Math.max(arr[index].end, arr[i].end);
                arr[index].start = Math.min(arr[index].start, arr[i].start);
            } else {
                arr[index] = arr[i];
                index++;
            }
        }

        // Now arr[0..index-1] stores the merged Intervals
        System.out.print("The Merged Intervals are: ");
        for (int i = 0; i <= index; i++) {
            System.out.print("[" + arr[i].start + ","
                    + arr[i].end + "]");
        }
    }


    public int[][] merge(int[][] intervals) {
        int len = intervals.length;

        if (len <= 0) {
            return new int[][]{};
        }
        if (len == 1) {
            return new int[][]{{intervals[0][0], intervals[0][1]}};
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                return i1[0] - i2[0];
            }
        });
        Stack<int[]> st = new Stack<>();
        for (int[] pair : intervals) {
            if (st.isEmpty()) {
                st.push(pair);
            } else {
                if (st.peek()[1] < pair[0]) {
                    st.push(pair);
                } else if (st.peek()[1] < pair[1]) {
                    int[] set = {st.peek()[0], pair[1]};
                    st.pop();
                    st.push(set);
                }

            }

        }

        int[][] sets = new int[st.size()][2];
        while (!st.isEmpty()) {
            sets[st.size() - 1][0] = st.peek()[0];
            sets[st.size() - 1][1] = st.peek()[1];
            st.pop();
        }
        return sets;
    }
}
