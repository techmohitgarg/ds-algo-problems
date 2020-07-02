package com.mohit.leetcode.tree.medium;


import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class EqualTreePartition {
    TreeNode lastNode = null;
    TreeNode head = null;

    public static void main(String[] args) {
        EqualTreePartition sol = new EqualTreePartition();
        TreeNode root1 = MakeTree.stringToTreeNode("[1,#,10,15,4]".replace("#", "null"));
        System.out.println(sol.checkEqualTree(root1));
    }

    boolean isMatch = false;
    public boolean checkEqualTree(TreeNode root) {
        if (root == null) return false;
        TreeNode head = root;
        int totalTreeSum = totalSum(root);

        checkSumEqual(root, totalTreeSum, head);

        return isMatch;
    }

    private int checkSumEqual(TreeNode root, int totalSum, TreeNode head) {
        if (root == null) return 0;

        int left = checkSumEqual(root.left, totalSum, head);
        int right = checkSumEqual(root.right, totalSum, head);
        int checkSum = left + right + root.val;
        if (totalSum - checkSum == checkSum) {
            if (root != head) {
                isMatch = true;
                return 0;
            }
        }
        return checkSum;
    }
    private int totalSum(TreeNode root) {
        if (root == null) return 0;
        return totalSum(root.left) + totalSum(root.right) + root.val;
    }

}