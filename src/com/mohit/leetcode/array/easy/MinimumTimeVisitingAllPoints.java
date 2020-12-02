package com.mohit.leetcode.array.easy;

public class MinimumTimeVisitingAllPoints {

    /**
     *TC : O(N)
     * SC: O(1)
     */
    public int minTimeToVisitAllPoints(int[][] points) {
        int timeSec = 0;

        for (int i = 1; i < points.length; i++) {
            int x = Math.abs(points[i - 1][0] - points[i][0]);
            int y = Math.abs(points[i - 1][1] - points[i][1]);
            timeSec += Math.max(x, y);
        }

        return timeSec;

    }
    
}
