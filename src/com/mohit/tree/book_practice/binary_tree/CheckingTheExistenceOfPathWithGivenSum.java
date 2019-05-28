package com.mohit.tree.book_practice.binary_tree;


public class CheckingTheExistenceOfPathWithGivenSum {
    public static void main(String[] args) {
        CheckingTheExistenceOfPathWithGivenSum existence = new CheckingTheExistenceOfPathWithGivenSum();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        System.out.println(existence.isHasPath(tree, 11));
    }

    public boolean isHasPath(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum == root.val) {
            return true;
        }
        return isHasPath(root.left, sum - root.val) || isHasPath(root.right, sum - root.val);
    }
}
