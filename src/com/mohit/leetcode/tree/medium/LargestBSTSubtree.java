package com.mohit.leetcode.tree.medium;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

/**
 * https://leetcode.com/problems/largest-bst-subtree/
 */
public class LargestBSTSubtree {
    public static void main(String[] args) {
        LargestBSTSubtree sol = new LargestBSTSubtree();
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(60);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(20);
        root.right.left = new TreeNode(45);
        root.right.right = new TreeNode(70);
        root.right.right.left = new TreeNode(65);
        root.right.right.right = new TreeNode(80);
        int result = sol.largestBST(root);

        System.out.println(result);
    }


    //region Find the largest BST subtree in a given Binary Tree
    class MinMax {
        int maxLength = 0;
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        boolean isBST = true;
    }

    public int largestBST(TreeNode root) {
        if (root == null) return 0;

        MinMax ans = getLargestBST(root);
        return ans.maxLength;
    }

    private MinMax getLargestBST(TreeNode root) {
        if (root == null) return new MinMax();

        MinMax left = getLargestBST(root.left);
        MinMax right = getLargestBST(root.right);
        MinMax result = new MinMax();
        if (left.isBST == false || right.isBST == false || left.maxValue > root.val || right.minValue < root.val) {
            result.isBST = false;
            result.maxLength = Math.max(left.maxLength, right.maxLength);
            result.minValue = 0;
            result.maxValue = 0;
            return result;
        }

        result.isBST = true;
        result.maxLength = 1 + left.maxLength + right.maxLength;
        result.minValue = Math.min(left.minValue, root.val);
        result.maxValue = Math.max(right.maxValue, root.val);

        return result;
    }


    /*public int largestBST(TreeNode root) {
        if (root == null) return 0;

        int left = largestBST(root.left);
        int right = largestBST(root.right);
        int max = 0;
        lastNode = null;
        if (isValidBST(root)) {
            max = maxSize(root);
        }

        return Math.max(max, Math.max(left, right));
    }

    private int maxSize(TreeNode root) {
        if (root == null) return 0;
        return 1 + maxSize(root.left) + maxSize(root.right);
    }*/
    //engregion
}
