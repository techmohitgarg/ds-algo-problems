package com.mohit.leetcode.array.easy;

public class NumberOfStudentsDoingHomeworkAtGivenTime {

    /**
     * Constraints:
     * <p>
     * startTime.length == endTime.length
     * 1 <= startTime.length <= 100
     * 1 <= startTime[i] <= endTime[i] <= 1000
     * 1 <= queryTime <= 1000
     *
     * TC : O(N)
     * SC : O(1)
     */

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int result = 0;
        int i = 0;
        int len = startTime.length;
        while (i < len) {
            int start = startTime[i];
            int end = endTime[i];
            if (start <= queryTime && end >= queryTime) {
                result++;
            }
            i++;
        }
        return result;
    }
}
