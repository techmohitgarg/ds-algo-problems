package com.mohit.tree.book_practice.binary_tree;

import java.util.HashMap;

public class FindingTheVerticalSumBinaryTree {

    public static void main(String[] s) {
        FindingTheVerticalSumBinaryTree verticalSumBinaryTree = new FindingTheVerticalSumBinaryTree();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        verticalSumBinaryTree.findSum(tree);
    }

    public void findSum(TreeNode root) {
        if (root == null) {
            return;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        findVerticalNode(map, root, 0);
        for (int k : map.keySet()) {
            System.out.println("Key(Pos): " + k + " Sum :" + map.get(k));
        }
    }

    public void findVerticalNode(HashMap<Integer, Integer> map, TreeNode root, int height) {
        if (root.left != null) {
            findVerticalNode(map, root.left, height - 1);
        }
        if (root.right != null) {
            findVerticalNode(map, root.right, height + 1);
        }

        int data = 0;
        if (map.containsKey(height)) {
            data = map.get(height);
        }
        map.put(height, data + root.val);
    }
}
