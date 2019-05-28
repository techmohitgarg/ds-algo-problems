package com.mohit.leetcode.tree.easy;


import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.HashMap;


public class PathSumIII {
    public static void main(String[] s) {
        PathSumIII sumIII = new PathSumIII();
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(-3);
        node.right.right = new TreeNode(11);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(2);
        node.left.right.right = new TreeNode(1);
        node.left.left.left = new TreeNode(3);
        node.left.left.right = new TreeNode(-2);
        System.out.println(sumIII.pathSum(node, 8));
    }


    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        HashMap<Integer, Integer> perSum = new HashMap<>();
        int count = sumCount(root, 0, sum, perSum);
        return count;
    }


    public int sumCount(TreeNode root, int currentSum, int target, HashMap<Integer, Integer> perSum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        currentSum += root.val;
        if (perSum.containsKey(currentSum - target)) {
            count += perSum.get(currentSum - target);
        }

        if (!perSum.containsKey(currentSum)) {
            perSum.put(currentSum, 1);
        } else {
            perSum.put(currentSum, perSum.get(currentSum) + 1);
        }
        count += sumCount(root.left, currentSum, target, perSum);
        count += sumCount(root.right, currentSum, target, perSum);
        perSum.put(currentSum, perSum.get(currentSum) - 1);
        return count;
    }

}
