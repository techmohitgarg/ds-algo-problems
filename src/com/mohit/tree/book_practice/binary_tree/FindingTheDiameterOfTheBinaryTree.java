package com.mohit.tree.book_practice.binary_tree;

import com.mohit.TreeBookPractice;

public class FindingTheDiameterOfTheBinaryTree {
    public static void main(String[] args) {
        FindingTheDiameterOfTheBinaryTree diameterOfTheBinaryTree =
                new FindingTheDiameterOfTheBinaryTree();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        System.out.println(diameterOfTheBinaryTree.getDiameterOfTree(tree));
        System.out.println(diameterOfTheBinaryTree.getDiameterTreeUsingIterate(tree));
        System.out.println(diameterOfTheBinaryTree.diameterOpt(tree, new Height()));
        diameterOfTheBinaryTree.diameterUsingHeight(tree);
        System.out.println(MaxHeight.height);
    }


    public int maxHeightOrDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int maxLeft = maxHeightOrDepth(node.left);
        int maxRight = maxHeightOrDepth(node.right);
        if (maxLeft > maxRight) {
            return 1 + maxLeft;
        } else {
            return 1 + maxRight;
        }
    }

    private int getDiameterOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int len1 = maxHeightOrDepth(root.left) + maxHeightOrDepth(root.right) + 1;
        int len2 = Math.max(getDiameterOfTree(root.left), getDiameterOfTree(root.right));
        return Math.max(len1, len2);
    }

    private int getDiameterTreeUsingIterate(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int height = maxHeightOrDepth(node);
        int max = 0;
        for (int i = 0; i <= height; i++) {
            max = Math.max(max, getDiameterCount(node, i));
        }
        return max;
    }

    private int getDiameterCount(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        return getDiameterCount(root.left, k - 1) + getDiameterCount(root.right, k - 1);
    }
    // region Calculate the height with help of diameter function as well than maybe its works for O(n)
    static class Height {
        int h;
    }

    int diameterOpt(TreeNode root, Height height) {
        /* lh --> Height of left subtree
           rh --> Height of right subtree */
        Height lh = new Height(), rh = new Height();
        if (root == null) {
            height.h = 0;
            return 0; /* diameter is also 0 */
        }
        int ldiameter = diameterOpt(root.left, lh);
        int rdiameter = diameterOpt(root.right, rh);

        height.h = Math.max(lh.h, rh.h) + 1;
        return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
    }
    //endregion


    //region Get the diameter of tree is nothing but (left_right+1) so
    static class MaxHeight {
        static int height = Integer.MIN_VALUE;
    }

    public int diameterUsingHeight(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = diameterUsingHeight(root.left);
        int rightHeight = diameterUsingHeight(root.right);

        // Calculate the Max Diameter of tree here
        MaxHeight.height = Math.max(MaxHeight.height, 1 + leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }
    //endregion


    // region this is O(n2) solution will try this O(n)
    public int findMaxDiameterTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // Find the hieght of left and right subtree
        int height = width(root.left) + width(root.right) + 1;
        // Find the Diameter of  left and right subtree
        int diameter = Math.max(findMaxDiameterTree(root.left), findMaxDiameterTree(root.right));

        return Math.max(height, diameter);
    }


    // find the width if tree
    public int width(TreeNode root) {
        if (root == null) return 0;
        int left = width(root.left);
        int right = width(root.right);
        return 1 + Math.max(left, right);
    }
    // endregion
}



