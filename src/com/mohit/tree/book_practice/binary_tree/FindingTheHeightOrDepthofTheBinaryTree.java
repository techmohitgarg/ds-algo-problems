package com.mohit.tree.book_practice.binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FindingTheHeightOrDepthofTheBinaryTree {

    public static void main(String[] args) {
        FindingTheHeightOrDepthofTheBinaryTree heightOrDepthofTheBinaryTree = new FindingTheHeightOrDepthofTheBinaryTree();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        System.out.println(heightOrDepthofTheBinaryTree.maxHeightOrDepth(tree));
        System.out.println(heightOrDepthofTheBinaryTree.maxHeightOrDepthIterateMode(tree));
        System.out.println(heightOrDepthofTheBinaryTree.minDepth(tree));
        System.out.println(heightOrDepthofTheBinaryTree.minHeightOrDepth(tree));
    }


    public int maxHeightOrDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int maxLeft = maxHeightOrDepth(node.left);
        int maxRight = maxHeightOrDepth(node.right);
        if (maxLeft > maxRight) {
            return 1 + maxLeft;
        } else {
            return 1 + maxRight;
        }
    }

    public int maxHeightOrDepthIterateMode(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int max = 0;
        Stack<TreeNode> nodes = new Stack<>();
        nodes.add(node);
        TreeNode prev = null;
        while (!nodes.isEmpty()) {
            TreeNode current = nodes.peek();
            if (prev == null || prev.left == current || prev.right == current) {
                if (current.left != null) {
                    nodes.add(current.left);
                } else if (current.right != null) {
                    nodes.add(current.right);
                }
            } else if (current.left == prev) {
                if (current.right != null) {
                    nodes.add(current.right);
                }
            } else {
                nodes.pop();
            }
            prev = current;
            if (max < nodes.size()) {
                max = nodes.size();
            }
        }
        return max;
    }

    public int minHeightOrDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        if (node.left == null) {
            return 1 + minHeightOrDepth(node.right);
        }
        if (node.right == null) {
            return 1 + minHeightOrDepth(node.left);
        }
        return 1 + Math.min(minHeightOrDepth(node.left), minHeightOrDepth(node.right));
    }

    public int minDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int max = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        queue.offer(null);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                if (current.left == null && current.right == null) {
                    return max;
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            } else {
                if (!queue.isEmpty()) {
                    max++;
                    queue.offer(null);
                }
            }
        }
        return max;
    }

    public int hasPathSum(TreeNode A, int B) {
        return hasPath(A, B) ? 1 : 0;
    }

    public boolean hasPath(TreeNode A, int B) {
        if (A == null) {
            return false;
        }

        if (A.left == null && A.right == null && B == A.val) {
            return true;
        }
        return hasPath(A.left, B - A.val) || hasPath(A.right, B - A.val);
    }
}
