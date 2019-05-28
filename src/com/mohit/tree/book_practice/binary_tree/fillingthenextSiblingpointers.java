package com.mohit.tree.book_practice.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class fillingthenextSiblingpointers {

    public static void main(String[] s) {
        fillingthenextSiblingpointers siblingpointers = new fillingthenextSiblingpointers();
        SiblingTreeNode tree = new SiblingTreeNode(1);
        tree.left = new SiblingTreeNode(2);
        tree.right = new SiblingTreeNode(3);
        tree.left.left = new SiblingTreeNode(4);
        tree.left.right = new SiblingTreeNode(5);
        tree.right.left = new SiblingTreeNode(6);
        tree.right.right = new SiblingTreeNode(7);
        siblingpointers.levelOrderTraversal1(tree);
        siblingpointers.levelOrderTraversal2(tree);
    }

    public void levelOrderTraversal1(SiblingTreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.SiblingNode = root.right;
        }

        if (root.right != null) {
            if (root.SiblingNode != null) {
                root.right.SiblingNode = root.SiblingNode.left;
            }
        }
        levelOrderTraversal1(root.left);
        levelOrderTraversal1(root.right);
    }

    public void levelOrderTraversal2(SiblingTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<SiblingTreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        nodes.offer(null);
        while (!nodes.isEmpty()) {
            SiblingTreeNode node = nodes.poll();
            if (node != null) {
                node.SiblingNode = nodes.peek();
                if (node.left != null) {
                    nodes.offer(node.left);
                }
                if (node.right != null) {
                    nodes.offer(node.right);
                }
            } else {
                if (!nodes.isEmpty()) {
                    nodes.offer(null);
                }
            }
        }
        System.out.println(root);
    }
}
