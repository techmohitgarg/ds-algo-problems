package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrder {

    public static void main(String[] args) {
        BinaryTreeLevelOrder treeLevelOrder = new BinaryTreeLevelOrder();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        System.out.println(treeLevelOrder.levelOrderBottom(tree));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return 1 + Math.max(leftMax, rightMax);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        int maxDepth = maxDepth(root);
        for (int i = maxDepth; i > 0; i--) {
            List<Integer> list = new ArrayList<>();
            addReversData(list, i, root);
            lists.add(list);
        }
        return lists;

    }

    public void addReversData(List<Integer> list, int depth, TreeNode root) {
        if (root == null || depth < 1) {
            return;
        }
        if (depth == 1) {
            list.add(root.val);
        }
        addReversData(list, depth - 1, root.left);
        addReversData(list, depth - 1, root.right);
    }


    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode temp = nodes.poll();
            if (temp.right != null) {
                nodes.add(temp.right);
            }
            if (temp.left != null) {
                nodes.add(temp.left);
            }
            nodeStack.push(temp);
        }
        System.out.print("[");
        while (!nodeStack.isEmpty()) {
            System.out.print(String.valueOf(nodeStack.pop().val) + ",");
        }
        System.out.print("]");

        return lists;
    }
}
