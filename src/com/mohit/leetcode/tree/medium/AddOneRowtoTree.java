package com.mohit.leetcode.tree.medium;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowtoTree {

    public static void main(String[] s) {
        AddOneRowtoTree addOneRowtoTree = new AddOneRowtoTree();
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.right = new TreeNode(6);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(1);
        node.right.left = new TreeNode(5);
        TreeNode treeNode = addOneRowtoTree.addOneRow(node, 1, 2);
        System.out.println(treeNode);
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) {
            return null;
        }
        return addOne(root, 0, v, d, true);
    }

    public TreeNode addOne(TreeNode root, int maxDepth, int v, int d, boolean b) {
        if (root == null) {
            if (maxDepth == d - 1) {
                TreeNode nodeNew = new TreeNode(v);
                return nodeNew;
            }
            return root;
        }

        if (maxDepth == d - 1) {
            TreeNode nodeNew = new TreeNode(v);
            if (b) {
                nodeNew.left = root;
            } else {
                nodeNew.right = root;
            }
            return nodeNew;
        }
        root.left = addOne(root.left, maxDepth + 1, v, d - 1, true);
        root.right = addOne(root.right, maxDepth + 1, v, d - 1, false);
        return root;
    }


    public TreeNode addOneRow1(TreeNode root, int v, int d) {
        if (root == null) {
            return null;
        }
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty() && d > 1) {
            int size = stack.size();
            d--;
            while (size > 0) {
                if (d == 1) {
                    TreeNode temp = stack.poll();
                    // Store Previous node
                    TreeNode tempLeft = temp.left;
                    TreeNode tempright = temp.right;
                    // Add New Node
                    TreeNode leftNode = new TreeNode(v);
                    TreeNode rightNode = new TreeNode(v);
                    // Assign temp node to new Node
                    leftNode.left = tempLeft;
                    rightNode.right = tempright;
                    temp.left = leftNode;
                    temp.right = rightNode;
                } else {
                    TreeNode temp = stack.poll();
                    if (temp.left != null) {
                        stack.add(temp.left);
                    }
                    if (temp.right != null) {
                        stack.add(temp.right);
                    }
                }
                size--;
            }
        }
        return root;
    }
}
