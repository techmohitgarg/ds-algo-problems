package com.mohit.leetcode.tree.medium;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class HouseRobberIII {

    public static void main(String[] s) {
        HouseRobberIII robberIII = new HouseRobberIII();
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(3);
        node.right.right = new TreeNode(1);
        System.out.println(robberIII.rob(node));
    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = 0;
        int pervSum = 0;
        int nextSum = 0;
        boolean isSum = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            while (size > 0) {
                TreeNode temp = queue.poll();
                sum += temp.val;
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                size--;
            }
            if (isSum) {
                nextSum += sum;
                max = Math.max(max, nextSum);
            } else {
                pervSum += sum;
                max = Math.max(max, pervSum);
            }
            isSum = !isSum;
        }
        return max;
    }

}
