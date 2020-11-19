package com.mohit.leetcode.array.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {

    /**
     * Constraints:
     * <p>
     * 2 <= candies.length <= 100
     * 1 <= candies[i] <= 100
     * 1 <= extraCandies <= 50
     *
     * @param candies      array of candies integer
     * @param extraCandies array of extra candies integer
     * @return list of boolean value those candies can make greater with extra candies
     * TC : O(N)
     * SC : O(1) if ignore the return result otherwise SC = O(n)
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> resultList = new ArrayList<>();
        if (candies.length > 0) {

            int max = candies[0];

            for (int i = 1; i < candies.length; i++) {
                max = Math.max(max, candies[i]);
            }
            for (int i = 0; i < candies.length; i++) {
                resultList.add((candies[i] + extraCandies) >= max ? true : false);
            }

        }
        return resultList;
    }

}
