package com.mohit.leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

public class CreateTargetArrayInTheGivenOrder {

    /**
     * Constraints:
     * <p>
     * 1 <= nums.length, index.length <= 100
     * nums.length == index.length
     * 0 <= nums[i] <= 100
     * 0 <= index[i] <= i
     *
     * @param nums  array of integer
     * @param index array of integer
     * @return array of integer with target's value
     * TC : (O(N)*(O(N)+O(1))+O(N) --> O(N^2)+O(N) --> O(N^2)
     * SC : O(1) if ignore the return result otherwise SC = O(N)
     */
    public int[] createTargetArray(int[] nums, int[] index) {

        if (nums.length == 0) return new int[]{};

        List<Integer> targetList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) { // O(N)
            int num = nums[i];
            int ind = index[i];

            if (targetList.size() == ind) {
                targetList.add(num); //O(1)
            } else {
                targetList.add(ind, num);//O(N)
            }
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) { //O(N)
            result[i] = targetList.get(i);
        }
        return result;
    }

}
