package com.mohit.leetcode.tree.hard;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class BinaryTreeMaximumPathSum {


    public static void main(String[] s) {
        BinaryTreeMaximumPathSum pathSum = new BinaryTreeMaximumPathSum();

        TreeNode node = new TreeNode(1);
        System.out.println(pathSum.maxPathSum(node));
    }

    public int maxPathSum(TreeNode root) {
        Res res = new Res();
        getMaxSum(root, res);
        return res.val;
    }

    static class Res {
        int val = Integer.MIN_VALUE;
    }

    public int getMaxSum(TreeNode node, Res res) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            res.val = Math.max(res.val, node.val);
            return node.val;
        }
        int ls = getMaxSum(node.left, res);
        int rs = getMaxSum(node.right, res);
        int single_top = Math.max(Math.max(ls, rs) + node.val, node.val);
        int max_top = Math.max(ls + rs + node.val, single_top);
        res.val = Math.max(res.val, max_top);
        return single_top;
    }
}
