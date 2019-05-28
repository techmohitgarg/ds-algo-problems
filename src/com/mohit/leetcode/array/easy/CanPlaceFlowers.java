package com.mohit.leetcode.array.easy;

/*
Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: True
Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: False
Note:
The input array won't violate no-adjacent-flowers rule.
The input array size is in the range of [1, 20000].
n is a non-negative integer which won't exceed the input array size.

https://leetcode.com/problems/can-place-flowers/
 */
class CanPlaceFlowers {
    public static void main(String[] args) {
        CanPlaceFlowers flowers = new CanPlaceFlowers();
        int[] nums = {1, 0, 0, 0, 1};
        int n = 1;
        System.out.println(flowers.canPlaceFlowers(nums, n));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int size = flowerbed.length;
        if (size == 0 || size < n) {
            return false;
        }
        int count = 0;
        int next = 0;
        int prev = 0;
        for (int i = 0; i < size && count < n; i++) {
            if (flowerbed[i] == 0) {
                next = (i == size - 1) ? 0 : flowerbed[i + 1];
                prev = (i == 0) ? 0 : flowerbed[i - 1];
                if (next == 0 && prev == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count == n;
    }
}