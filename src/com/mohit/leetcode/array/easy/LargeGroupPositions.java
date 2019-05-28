package com.mohit.leetcode.array.easy;
/**
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 * Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
 * The final answer should be in lexicographic order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * Input: "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 * <p>
 * Example 2:
 * Input: "abc"
 * Output: []
 * Explanation: We have "a","b" and "c" but no large group.
 * Example 3:
 * <p>
 * Input: "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 * <p>
 * <p>
 * Note:  1 <= S.length <= 1000
 * <p>
 * https://leetcode.com/problems/positions-of-large-groups/
 */

import java.util.ArrayList;
import java.util.List;

class LargeGroupPositions {
    public static void main(String[] args) {
        LargeGroupPositions groupPositions = new LargeGroupPositions();
        String s = "abcdddeeeeaabbbcd";
        List<List<Integer>> result = groupPositions.largeGroupPositions(s);
        System.out.println(result);
    }

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        int i = 0;
        for (i = 0; i < S.length(); ) {
            if (S.charAt(start) == S.charAt(i)) {
                i++;
                continue;
            } else {
                end = i - 1;
                if (start != end && (end - start) + 1 > 2) {
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(end);
                    result.add(list);
                }
                start = i;
            }
        }
        if (start >= end && i == S.length()) {
            end = i - 1;
            if (start != end && (end - start) + 1 > 2) {
                List<Integer> list = new ArrayList<>();
                list.add(start);
                list.add(end);
                result.add(list);
            }
        }
        return result;
    }
}