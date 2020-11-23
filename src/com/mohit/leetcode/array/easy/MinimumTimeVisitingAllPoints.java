package com.mohit.leetcode.array.easy;

public class MinimumTimeVisitingAllPoints {

    /**
     *
     */

    public int minTimeToVisitAllPoints(int[][] points) {
        int timeSec = 0;

        for (int i = 1; i < points.length; i++) {

            int x = Math.abs(points[i - 1][0]) + Math.abs(points[i][0]);
            int y = Math.abs(points[i - 1][1]) + Math.abs(points[i][1]);
            System.out.printf(x + " : " + y);
            timeSec += Math.max(x, y);
            System.out.println();
        }

        return timeSec;

    }
}
