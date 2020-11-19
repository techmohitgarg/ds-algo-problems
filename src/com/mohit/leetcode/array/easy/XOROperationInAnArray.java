package com.mohit.leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

public class XOROperationInAnArray {

    /**
     * Constraints:
     * <p>
     * 1 <= n <= 1000
     * 0 <= start <= 1000
     * n == nums.length
     *
     * TC : O(N)
     * SC : O(1)
     */
    public int xorOperation(int n, int start) {
        if (n == 0) return 0;
        int result = start;
        int i = 1;
        while (i < n) {
            int curr = start + (2 * i);
            result = (result ^ curr);
            i++;
        }

        return result;
    }

}
