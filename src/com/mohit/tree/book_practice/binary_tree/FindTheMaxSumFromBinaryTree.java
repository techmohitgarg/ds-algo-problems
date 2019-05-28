package com.mohit.tree.book_practice.binary_tree;

public class FindTheMaxSumFromBinaryTree {


    public static void main(String[] args) {
        FindTheMaxSumFromBinaryTree sumFromBinaryTree = new FindTheMaxSumFromBinaryTree();
        TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(10);
        tree.left.left = new TreeNode(20);
        tree.left.right = new TreeNode(1);
        tree.right.right = new TreeNode(-25);
        tree.right.right.left = new TreeNode(3);
        tree.right.right.right = new TreeNode(4);
        Res res = new Res();
        res.sum = Integer.MIN_VALUE;
        sumFromBinaryTree.getMaxSumFromTwoLeave(tree, res);
        System.out.println(res.sum);
        System.out.println(sumFromBinaryTree.getMaxSum(tree, res));
        System.out.println(res.val);

    }


    // Max Sum

    static class Res {
        int sum;
        int val;
    }

    private int getMaxSumFromTwoLeave(TreeNode node, Res res) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return node.val;
        }

        int ls = getMaxSumFromTwoLeave(node.left, res);
        int rs = getMaxSumFromTwoLeave(node.right, res);

        if (node.left != null && node.right != null) {
            res.sum = Math.max(res.sum, ls + rs + node.val);
            return Math.max(ls, rs) + node.val;
        }
        return (node.left == null ? rs + node.val : ls + node.val);
    }

    private int getMaxSum(TreeNode node, Res res) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
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
