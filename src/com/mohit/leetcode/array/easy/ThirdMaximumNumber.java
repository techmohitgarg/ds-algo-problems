package com.mohit.leetcode.array.easy;

/*
Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]
Output: 1
Explanation: The third maximum is 1.

Example 2:
Input: [1, 2]
Output: 2
Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

Example 3:
Input: [2, 2, 3, 1]
Output: 1
Explanation: Note that the third maximum here means the third maximum distinct number.

Both numbers with value 2 are both considered as second maximum.
 */
public class ThirdMaximumNumber {
    public static void main(String[] args) {
        ThirdMaximumNumber number = new ThirdMaximumNumber();
        int[] nums = {5, 2, 4, 1, 3, 6, 0};
        int result = number.thirdMax(nums);
        System.out.println(result);
    }

    public int thirdMax(int[] nums) {
        Integer m1 = null, m2 = null, m3 = null;
        for (int i = 0; i < nums.length; i++) {
            if (m1 == null) {
                m1 = nums[i];
            }
            m1 = Math.max(m1, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < m1) {
                if (m2 == null) {
                    m2 = nums[i];
                }
                m2 = Math.max(m2, nums[i]);
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < m1 && nums[i] < m2) {
                if (m3 == null) {
                    m3 = nums[i];
                }
                m3 = Math.max(m3, nums[i]);
            }

        }
        return m3 == null ? m1 : m3;
    }

    public int thirdMax1(int[] nums) {
        Integer m1 = null, m2 = null, m3 = null;
        for (int i = 0; i < nums.length; i++) {
            Integer temp = nums[i];
            if (temp.equals(m1) || temp.equals(m2) || temp.equals(m3)) {
                continue;
            }
            if (m1 == null || temp > m1) {
                m3 = m2;
                m2 = m1;
                m1 = temp;
            } else if (m2 == null || temp > m2) {
                m3 = m2;
                m2 = temp;
            } else if (m3 == null || temp > m3) {
                m3 = temp;
            }
        }
        return m3 == null ? m1 : m3;
    }
}
