package com.mohit.stacks.leetcode;

import java.util.List;

public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater water = new TrappingRainWater();
        System.out.println(water.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));

    }

    /*public int trap(int[] height) {
        int ans = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            if (height[left] < height[right]) {
                ans += maxLeft - height[left];
                left++;
            } else {
                ans += maxRight - height[right];
                right--;
            }
        }
        return ans;
    }*/

    public int trap(int[] height) {
        int ans = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        for (int i = 0; i < left.length; i++) {
            left[i] = (i == 0 ? height[i] : Math.max(left[i - 1], height[i]));
        }
        for (int i = right.length - 1; i >= 0; i--) {
            right[i] = (i == right.length - 1 ? height[i] : Math.max(right[i + 1], height[i]));
        }

        for (int i = 1; i < left.length - 1; i++) {
            ans += Math.min(left[i], right[i]) - height[i];
        }
        return ans;
    }
}
