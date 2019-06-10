/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.leetcode.strings.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Mohit Garg
 */
public class MinimumTimeDifference {

    public static void main(String[] args) {
        MinimumTimeDifference bcii = new MinimumTimeDifference();
        List<String> timePoints = new ArrayList<>();
        timePoints.add("05:31");
        timePoints.add("22:08");
        timePoints.add("00:35");
        System.out.println(bcii.findMinDifference(timePoints));
    }

    public int findMinDifference(List<String> timePoints) {
        int mindiff = Integer.MAX_VALUE;
        int n = timePoints.size();
        Collections.sort(timePoints);
        for (int i = 0; i < timePoints.size(); i++) {
            int diff = Math.abs(getDiff(timePoints.get((i - 1 + n) % n).split(":"), timePoints.get(i).split(":")));
            diff = Math.min(diff, 1440 - diff);
            mindiff = Math.min(mindiff, diff);
        
        }
        return mindiff;
    }

    private int getDiff(String[] s1, String[] s2) {
        int h1 = Integer.parseInt(s1[0]);
        int m1 = Integer.parseInt(s1[1]);
        int h2 = Integer.parseInt(s2[0]);
        int m2 = Integer.parseInt(s2[1]);
        return (h2 - h1) * 60 + (m2 - m1);
    }
}
