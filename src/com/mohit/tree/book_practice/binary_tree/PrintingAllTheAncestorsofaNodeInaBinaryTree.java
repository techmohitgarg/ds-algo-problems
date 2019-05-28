package com.mohit.tree.book_practice.binary_tree;

public class PrintingAllTheAncestorsofaNodeInaBinaryTree {

    public static void main(String[] args) {
        PrintingAllTheAncestorsofaNodeInaBinaryTree nodeInaBinaryTree = new PrintingAllTheAncestorsofaNodeInaBinaryTree();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        System.out.println(nodeInaBinaryTree.printAllAncestors(tree, new TreeNode(4)));

    }


    public boolean printAllAncestors(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (root.val == node.val) {
            return true;
        }
        if (printAllAncestors(root.left, node)
                || printAllAncestors(root.right, node)) {
            System.out.println(root.val);
            return true;
        }
        return false;
    }

}
