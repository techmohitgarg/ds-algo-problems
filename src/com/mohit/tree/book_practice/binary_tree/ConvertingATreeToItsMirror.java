package com.mohit.tree.book_practice.binary_tree;

public class ConvertingATreeToItsMirror {

    public static void main(String[] args) {
        ConvertingATreeToItsMirror aTreeToItsMirror = new ConvertingATreeToItsMirror();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        TreeNode node = aTreeToItsMirror.mirrorOfTree(tree);
        System.out.println(node);
    }

    public TreeNode mirrorOfTree(TreeNode node) {
        if (node == null) {
            return node;
        }
        mirrorOfTree(node.left);
        mirrorOfTree(node.right);
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        return node;
    }


}
