package com.mohit.leetcode.tree.medium;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.*;

public class MostFrequentSubtreeSum {

    public static void main(String[] s) {
        MostFrequentSubtreeSum subtreeSum = new MostFrequentSubtreeSum();
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(2);
        node.right = new TreeNode(-5);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(9);
        node.right.right = new TreeNode(5);
        subtreeSum.findFrequentTreeSum(node);
    }

    int maxCount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        sumOfSubTree(root, map);

        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxCount == entry.getValue()) {
                list.add(entry.getKey());
            }
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }


    private int sumOfSubTree(TreeNode node, HashMap<Integer, Integer> map) {
        if (node == null) return 0;
        int sum = node.val;
        sum += sumOfSubTree(node.left, map);
        sum += sumOfSubTree(node.right, map);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        maxCount = Math.max(maxCount, map.get(sum));
        return sum;
    }

}
