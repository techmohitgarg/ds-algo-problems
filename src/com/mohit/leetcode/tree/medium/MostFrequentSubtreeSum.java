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

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        postOrder(map, root);
        List<Integer> l = new ArrayList();

        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                l.clear();
                l.add(entry.getKey());
            } else if (entry.getValue() == max) {
                l.add(entry.getKey());
            }
        }

        int[] res = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            res[i] = l.get(i);
        }

        return res;
    }

    public int postOrder(HashMap<Integer, Integer> map, TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = postOrder(map, root.left);
        int right = postOrder(map, root.right);
        int sum = root.val + left + right;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }

}
