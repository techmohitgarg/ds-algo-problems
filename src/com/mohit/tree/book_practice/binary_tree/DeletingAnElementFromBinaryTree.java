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
        elementFromBinaryTree.deleteNode(tree, 11);
        elementFromBinaryTree.inOrder(tree);

    }


    // find the deepest node of the tree
    public TreeNode deleteNode(TreeNode node, int deleteNode) {
        if (node == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        //Delete Node Data
        TreeNode delete = null;
        TreeNode treeNode = null;
        while (!queue.isEmpty()) {
            treeNode = queue.poll();
            if (treeNode.val == deleteNode) {
                delete = treeNode;
            }
            if (treeNode.left != null) queue.add(treeNode.left);
            if (treeNode.right != null) queue.add(treeNode.right);
        }
        if (delete != null) {
            // Deepest Node Value
            int val = treeNode.val;
            //Delete the Deepest Node from tree
            queue.add(node);
            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                if (temp == treeNode) {
                    temp = null;
                    break;
                }
                if (temp.left != null && temp.left == treeNode) {
                    temp.left = null;
                    break;
                } else {
                    queue.add(temp.left);
                }
                if (temp.right != null && temp.right == treeNode) {
                    temp.right = null;
                    break;
                } else {
                    queue.add(temp.right);
                }
            }

            // Add the Deepest Node at the Delete position
            delete.val = val;

        }

        return node;
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
