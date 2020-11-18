package com.mohit.leetcode.array.easy;

import java.util.HashMap;

public class NumberOfGoodPairs {


    /**
     * A pair (i,j) is called good if nums[i] == nums[j] and i < j
     * <p>
     * Constraints:
     * 1 <= nums.length <= 100
     * 1 <= nums[i] <= 100
     *
     * @param nums array of integer's
     * @return count of good pairs
     * TC : O(n^2)
     */
    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    result++;
                }
            }
        }
        return result;
    }


    /**
     *
     * TC : O(N) N is length of array(nums)
     * SC : O(M) M is size of hashmap(map)
     */
    public int numIdenticalPairs_(int[] nums) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                result += count;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return result;
    }
}
