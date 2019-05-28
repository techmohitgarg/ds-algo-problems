package com.mohit.leetcode.array.easy;

/*
In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.

Return that maximum distance to closest person.

Example 1:

Input: [1,0,0,0,1,0,1]
Output: 2
Explanation:
If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.
Example 2:

Input: [1,0,0,0]
Output: 3
Explanation:
If Alex sits in the last seat, the closest person is 3 seats away.
This is the maximum distance possible, so the answer is 3.

https://leetcode.com/problems/maximize-distance-to-closest-person/
 */
public class MaximizeDistancetoClosestPerson {

    public static void main(String[] args) {
        MaximizeDistancetoClosestPerson closestPerson = new MaximizeDistancetoClosestPerson();
        System.out.println(closestPerson.maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
    }

    public int maxDistToClosest(int[] seats) {
        if (seats == null || seats.length == 0) {
            return 0;
        }
        if (seats.length == 1 && seats[0] == 1) {
            return -1;
        }
        int[] dis = new int[seats.length];
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                dis[i] = (i == 0 ? 0 : (dis[i - 1] == 0 ? 0 : dis[i - 1] + 1));
            } else {
                for (int j = i; j >= 0; j--) {
                    if (j == i) {
                        dis[j] = 1;
                    } else {
                        if (dis[j] == 1 + dis[j + 1] || dis[j] == dis[j + 1]) {
                            break;
                        } else {
                            dis[j] = 1 + dis[j + 1];
                        }
                    }
                }
            }

        }
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < dis.length; i++) {
            if (max < dis[i]) {
                max = dis[i];
            }
        }
        return max - 1;
    }

}
