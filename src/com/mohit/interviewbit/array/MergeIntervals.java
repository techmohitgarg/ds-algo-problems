package com.mohit.interviewbit.array;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {


    public class Interval {
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
    }

    public static void main(String[] s) {

    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        int n = intervals.size();
        if (n <= 0) {
            return intervals;
        }
        ArrayList<Interval> list = new ArrayList<>();
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
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