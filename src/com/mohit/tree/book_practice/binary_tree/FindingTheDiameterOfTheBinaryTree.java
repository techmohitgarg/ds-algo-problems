package com.mohit.tree.book_practice.binary_tree;

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
}



