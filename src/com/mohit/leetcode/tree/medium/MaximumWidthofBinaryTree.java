package com.mohit.leetcode.tree.medium;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumWidthofBinaryTree {

    public static void main(String[] s) {
        MaximumWidthofBinaryTree binaryTree = new MaximumWidthofBinaryTree();
        TreeNode node = MakeTree.stringToTreeNode("[1,3,2,5,3,null,9]");

        System.out.println(binaryTree.widthOfBinaryTree(node));
    }

    class TreeNodeContext {
        TreeNode node;
        int index;

        public TreeNodeContext(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }


    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNodeContext> q = new LinkedList<>();
        q.offer(new TreeNodeContext(root, 1));
        int curW = 0;
        int maxW = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int start = 0;
            int end = 0;
            for (int i = 0; i < size; i++) {
                TreeNodeContext treeNodeContext = q.poll();
                TreeNode node = treeNodeContext.node;
                int index = treeNodeContext.index;
                if (i == 0) start = index;
                if (i == size - 1) end = index;
                if (node.left != null) {
                    q.offer(new TreeNodeContext(node.left, index * 2));
                }
                if (node.right != null) {
                    q.offer(new TreeNodeContext(node.right, index * 2 + 1));
                }
            }
            curW = end - start + 1;
            maxW = Math.max(curW, maxW);
        }
        return maxW;
    }
    /*public int widthOfBinaryTree(TreeNode root) {
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
    }*/
}
