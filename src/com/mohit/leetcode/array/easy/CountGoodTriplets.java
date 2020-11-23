package com.mohit.leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

public class CountGoodTriplets {

    /**
     * Constraints:
     * <p>
     * 3 <= arr.length <= 100
     * 0 <= arr[i] <= 1000
     * 0 <= a, b, c <= 1000
     *
     * @param arr
     * @param a
     * @param b
     * @param c
     * @return TC : O(n^3)
     * SC : O(1)
     */
    public int countGoodTriplets_(int[] arr, int a, int b, int c) {
        int result = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) > a)
                    continue;
                for (int k = j + 1; k < arr.length; k++) {
                    int x = Math.abs(arr[i] - arr[j]);
                    int y = Math.abs(arr[j] - arr[k]);
                    int z = Math.abs(arr[i] - arr[k]);
                    if (x <= a && y <= b && z <= c) {
                        result++;
                    }
                }
            }
        }


        return result;
    }

    /**
     * * TC : O(n^2)
     * * SC : O(n)
     */
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int result = 0;
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int x = Math.abs(arr[i] - arr[j]);
                if (x <= a) {
                    list.add(new int[]{i, j});
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int[] point = list.get(i);
            for (int j = point[1] + 1; j < arr.length; j++) {
                int y = Math.abs(arr[point[1]] - arr[j]);
                int z = Math.abs(arr[point[0]] - arr[j]);
                if (y <= b && z <= c) {
                    result++;
                }
            }

        }
        return result;
    }
}
