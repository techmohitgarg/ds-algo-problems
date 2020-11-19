package com.mohit.leetcode.array.easy;

public class ShuffleTheArray {

    /**
     * Constraints:
     * <p>
     * 1 <= n <= 500
     * nums.length == 2n
     * 1 <= nums[i] <= 10^3
     *
     * @param nums array of integer's size of 2n
     * @param n    size of array
     * @return array in the form [x1,y1,x2,y2,...,xn,yn]
     * TC :O(N)
     * SC :O(1) if ignore the return result otherwise SC = O(n)
     */
    public int[] shuffle(int[] nums, int n) {
        if (n <= 1) return nums;
        int[] result = new int[n * 2];
        int i = 0;
        int index = 0;
        while (i < n) {
            //x1,x2......xi
            result[index] = nums[i];
            index++;
            //y(n+1),y(n+2)......y(n+i)
            result[index] = nums[n + i];
            index++;
            i++;
        }

        return result;
    }
}
