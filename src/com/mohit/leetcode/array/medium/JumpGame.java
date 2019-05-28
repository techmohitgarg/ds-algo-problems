package com.mohit.leetcode.array.medium;

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
https://leetcode.com/problems/jump-game/
 */
public class JumpGame {
    public static void main(String[] args) {
        JumpGame game = new JumpGame();
        int[] arr = {2, 3, 1, 1, 4};
        System.out.println(game.canJump(arr));
    }

    //[0,2,3]
    //{0}
    //[1,0,1,0]
    //[2,0,1,0]
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        int lastIndex = nums.length - 1;
        int maxStep = nums[0];
        int i;
        for (i = 1; i < nums.length; i++) {
            if (maxStep > 0 && nums[i] >= maxStep && i != lastIndex) {
                maxStep = nums[i];
            } else if (maxStep >= 1 && i == lastIndex) {
                return true;
            } else {
                maxStep--;
            }
        }
        if (maxStep == 1 && i == lastIndex) {
            return true;
        }
        return false;
    }
}
