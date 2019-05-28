package com.mohit.leetcode.tree.medium;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersEachNode {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public static void main(String[] s) {
        PopulatingNextRightPointersEachNode eachNode = new PopulatingNextRightPointersEachNode();
        TreeLinkNode node = new TreeLinkNode(1);
        node.left = new TreeLinkNode(2);
        node.right = new TreeLinkNode(3);
        node.left.left = new TreeLinkNode(4);
        node.left.right = new TreeLinkNode(5);
        node.right.left = new TreeLinkNode(6);
        node.right.right = new TreeLinkNode(7);
        eachNode.connect(node);
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            root.left.next = root.right;
        }

        if (root.right != null) {
            if (root.next != null) {
                root.right.next = root.next.left;
            }

        }

        connect(root.left);
        connect(root.right);
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
        while (!nodes.isEmpty()) {
            TreeLinkNode node = nodes.poll();
            if (node != null) {
                node.next = nodes.peek();
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }

            } else {
                if (!nodes.isEmpty()) {
                    nodes.offer(null);
                }
            }

        }
    }
}
