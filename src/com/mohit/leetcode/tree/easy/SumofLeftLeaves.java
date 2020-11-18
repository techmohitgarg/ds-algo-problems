package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SumofLeftLeaves {

    public static void main(String[] args) {
        SumofLeftLeaves zigzagTreeTraversal = new SumofLeftLeaves();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        System.out.println(zigzagTreeTraversal.sumOfLeftLeaves(tree));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left == null && root.right == null) {
            return 0;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            TreeNode node = treeNodes.poll();
            if (node.left == null && node.right == null) {
                sum += node.val;
            }
            if (node.left != null) {
                treeNodes.add(node.left);
            }
            if (node.right != null && node.right.left != null) {
                treeNodes.add(node.right);
            }
        }
        return sum;
    }

    //region Sum of Left Leaves

    /**
     * @param root tree
     * @return sum of all the left nodes
     */
   /* public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    private int sumofLeft(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        int sum = 0;
        if (isLeft && root.left == null && root.right == null) {
            sum += root.val;
        }
        return sum + sumofLeft(root.left, true) + sumofLeft(root.right, false);
    }*/
    //endregion
}
