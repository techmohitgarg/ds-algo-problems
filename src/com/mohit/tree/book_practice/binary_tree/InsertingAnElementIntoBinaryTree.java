package com.mohit.tree.book_practice.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertingAnElementIntoBinaryTree {
    public static void main(String[] args) {
        InsertingAnElementIntoBinaryTree element = new InsertingAnElementIntoBinaryTree();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left=new TreeNode(6);
        tree.right.right = new TreeNode(7);
        tree.left.left.left = new TreeNode(8);
        tree.left.left.right = new TreeNode(9);

        tree.left.right.left = new TreeNode(10);
        tree.left.right.right = new TreeNode(11);

        new InsertingAnElementIntoBinaryTree().insert(12, tree);
    }

    //Recursively
    //This is working only for left subtree value node
    public TreeNode insert(int data, TreeNode node) {
        if (node == null) {
            node = new TreeNode(data);
        } else {
            if (node.left == null)
                node.left = new TreeNode(data);
            else if (node.right == null)
                node.right = new TreeNode(data);
            else {
                if (checkVaccancyAt(node.left)) {
                    insert(data, node.left);
                } else {
                    if (checkVaccancyAt(node.right))
                        insert(data, node.right);
                    else {
                        insert(data, node.left);
                    }
                }
            }
        }
        return node;
    }

    private boolean checkVaccancyAt(TreeNode node) {
        return node.left == null || node.right == null;
    }


    // This Solution is linear iterate solution with o(n) time Complexity
    public TreeNode insert1(TreeNode root, int data) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp != null) {
                if (temp.left == null) {
                    temp.left = new TreeNode(data);
                    break;
                } else {
                    queue.add(temp.left);
                }
                if (temp.right == null) {
                    temp.right = new TreeNode(data);
                    break;
                } else {
                    queue.add(temp.right);
                }
            }
        }
        return root;
    }

}
