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

    //region Most Frequent Subtree Sum
/*    int maxLen = 0;
    int count = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[]{};

        HashMap<Integer, Integer> mostFrequentSum = new HashMap<>();

        getSubTreeSum(root, mostFrequentSum);

        if (maxLen <= 0) {
            return new int[]{};
        } else {
            int[] result = new int[count];
            int i = 0;
            for (Map.Entry<Integer, Integer> e : mostFrequentSum.entrySet()) {
                if (e.getValue() == maxLen) {
                    result[i] = e.getKey();
                    i++;
                }
            }
            return result;
        }
    }

    private int getSubTreeSum(TreeNode root, HashMap<Integer, Integer> mostFrequentSum) {
        if (root == null) return 0;

        int left = getSubTreeSum(root.left, mostFrequentSum);
        int right = getSubTreeSum(root.right, mostFrequentSum);

        int sum = root.val + left + right;

        mostFrequentSum.put(sum, mostFrequentSum.getOrDefault(sum, 0) + 1);

        int len = mostFrequentSum.get(sum);

        if (len > maxLen) {
            maxLen = len;
            count = 1;
        } else if (maxLen == len) {
            count++;
        }
        return sum;
    }*/
    //endregion

}
