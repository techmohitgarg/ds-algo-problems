/*
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 */
package com.mohit.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
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
}
