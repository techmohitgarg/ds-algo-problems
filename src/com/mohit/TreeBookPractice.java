package com.mohit;

import com.mohit.tree.book_practice.binary_tree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

public class TreeBookPractice {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(10);
        a.left = new TreeNode(20);
        a.right = new TreeNode(30);
        a.right.right = new TreeNode(40);
        new TreeBookPractice().deleteNode(a, 20);

    }


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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }


}
