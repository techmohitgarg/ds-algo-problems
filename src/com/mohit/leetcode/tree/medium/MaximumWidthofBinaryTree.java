package com.mohit.leetcode.tree.medium;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumWidthofBinaryTree {

    public static void main(String[] s) {
        MaximumWidthofBinaryTree binaryTree = new MaximumWidthofBinaryTree();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(5);
        node.left.left.left = new TreeNode(6);
        node.right = new TreeNode(2);
        node.right.right = new TreeNode(9);
        node.right.right.right = new TreeNode(7);

        System.out.println(binaryTree.widthOfBinaryTree(node));
    }


    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Integer> m = new HashMap<>();
        q.offer(root);
        m.put(root, 1);
        int curW = 0;
        int maxW = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int start = 0;
            int end = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == 0) start = m.get(node);
                if (i == size - 1) end = m.get(node);
                if (node.left != null) {
                    m.put(node.left, m.get(node) * 2);
                    q.offer(node.left);
                }
                if (node.right != null) {
                    m.put(node.right, m.get(node) * 2 + 1);
                    q.offer(node.right);
                }
            }
            curW = end - start + 1;
            maxW = Math.max(curW, maxW);
        }
        return maxW;
    }
}
