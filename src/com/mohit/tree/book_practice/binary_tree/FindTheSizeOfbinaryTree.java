package com.mohit.tree.book_practice.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindTheSizeOfbinaryTree {

    public static void main(String[] args) {
        FindTheSizeOfbinaryTree ofbinaryTree = new FindTheSizeOfbinaryTree();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        System.out.println(ofbinaryTree.sizeOfTree1(tree));
    }

    //Time	Complexity:	O(n).	Space	Complexity:	O(n).
    public int sizeOfTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = node.left == null ? 0 : sizeOfTree(node.left);
        int right = node.left == null ? 0 : sizeOfTree(node.right);
        return 1 + left + right;
    }

    //Time	Complexity:	O(n).	Space	Complexity:	O(n).
    public int sizeOfTree1(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(node);
        int size = 0;
        while (!nodes.isEmpty()) {
            TreeNode temp = nodes.poll();
            if (temp != null) {
                size++;
            }
            if (temp.left != null) {
                nodes.add(temp.left);
            }
            if (temp.right != null) {
                nodes.add(temp.right);
            }
        }
        return size;
    }
}
