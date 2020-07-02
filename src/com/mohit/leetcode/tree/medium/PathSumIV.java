package com.mohit.leetcode.tree.medium;


import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PathSumIV {
    TreeNode lastNode = null;
    TreeNode head = null;

    public static void main(String[] args) {
        PathSumIV sol = new PathSumIV();
        TreeNode root1 = MakeTree.stringToTreeNode("[1,#,10,15,4]".replace("#", "null"));
        System.out.println(sol.pathSum(new int[]{213, 215, 221}));
    }

    int sum = 0;
    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> tree = new HashMap<>();
        Arrays.sort(nums);
        for (int num : nums) {
            int key = num / 10;
            int value = num % 10;
            tree.put(key, value);
        }

        traverse(nums[0] / 10, 0, tree);

        return sum;
    }

    private void traverse(int root, int preSum, Map<Integer, Integer> tree) {
        int level = root / 10;
        int pos = root % 10;
        int left = (level + 1) * 10 + pos * 2 - 1;
        int right = (level + 1) * 10 + pos * 2;

        int curSum = preSum + tree.get(root);

        if (!tree.containsKey(left) && !tree.containsKey(right)) {
            sum += curSum;
            return;
        }

        if (tree.containsKey(left)) traverse(left, curSum, tree);
        if (tree.containsKey(right)) traverse(right, curSum, tree);
    }


}