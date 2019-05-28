package com.mohit.leetcode.tree.medium;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersEachNode2 {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public static void main(String[] s) {
        PopulatingNextRightPointersEachNode2 eachNode = new PopulatingNextRightPointersEachNode2();
        TreeLinkNode node = new TreeLinkNode(1);
        node.left = new TreeLinkNode(2);
        node.right = new TreeLinkNode(3);
        node.left.left = new TreeLinkNode(4);
        node.left.right = new TreeLinkNode(5);
        node.right.right = new TreeLinkNode(6);
        node.left.left.left = new TreeLinkNode(7);
        node.right.right.right = new TreeLinkNode(8);
        eachNode.connect2(node);
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = getNextPointer(root);
            }
        }
        if (root.right != null) {
            if (root.next != null) {
                root.right.next = getNextPointer(root);
            }
        }

        connect(root.right);
        connect(root.left);
    }


    public TreeLinkNode getNextPointer(TreeLinkNode root) {
        if (root.next != null) {
            if (root.next.left != null) {
                return root.next.left;
            } else if (root.next.right != null) {
                return root.next.right;
            } else {
                return getNextPointer(root.next);
            }
        } else {
            return null;
        }

    }


    public void connect2(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode prev = root;
        TreeLinkNode curr = null;
        while (prev.left != null) {
            curr = prev;
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }

            prev = prev.left;

        }

    }

    public void connect1(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> nodes = new LinkedList<>();
        nodes.offer(root);
        nodes.offer(null);
        TreeLinkNode temp = null;
        while (!nodes.isEmpty()) {
            TreeLinkNode node = nodes.remove();
            if (temp != null) {
                temp.next = node;
                temp = temp.next;
            } else {
                temp = node;
            }

            if (node == null) {
                if (!nodes.isEmpty()) nodes.add(null);
            } else {
                if (node.left != null)
                    nodes.add(node.left);
                if (node.right != null)
                    nodes.add(node.right);
            }

        }
    }
}
