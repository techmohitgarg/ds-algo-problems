package com.mohit.tree.book_practice.binary_tree;


import java.util.LinkedList;
import java.util.Queue;

public class DeletingAnElementFromBinaryTree {

    public static void main(String[] args) {
        DeletingAnElementFromBinaryTree elementFromBinaryTree = new DeletingAnElementFromBinaryTree();
        TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(11);
        tree.left.left = new TreeNode(7);
        tree.left.right = new TreeNode(12);
        tree.right = new TreeNode(9);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(8);
        elementFromBinaryTree.inOrder(tree);
        System.out.println();
        elementFromBinaryTree.getDeepestNode(tree, 11);
        elementFromBinaryTree.inOrder(tree);

    }


    // find the deepest node of the tree
    public void getDeepestNode(TreeNode node, int deleteNode) {
        if (node == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        TreeNode treeNode = null;
        TreeNode tree = null;
        while (!queue.isEmpty()) {
            tree = queue.poll();
            if (tree.val == deleteNode) {
                treeNode = tree;
            }
            if (tree.left != null) {
                queue.add(tree.left);
            }
            if (tree.right != null) {
                queue.add(tree.right);
            }
        }
        int key = tree.val;
        deleteNode(node, tree);
        treeNode.val = key;
    }


    private void deleteNode(TreeNode root, TreeNode deleteNode) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode tree = nodeQueue.poll();
            if (tree.right != null) {
                if (tree.right == deleteNode) {
                    tree.right = null;
                    deleteNode = null;
                } else {
                    nodeQueue.add(tree.right);
                }

            }
            if (tree.left != null) {
                if (tree.left == deleteNode) {
                    tree.left = null;
                    deleteNode = null;
                } else {
                    nodeQueue.add(tree.left);
                }
            }
        }
    }


    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(String.valueOf(node.val) + ",");
        inOrder(node.right);
    }

}
