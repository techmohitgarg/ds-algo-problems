package com.mohit.leetcode.tree.medium;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class SerializeandDeserializeBST {

    public static void main(String[] args) {
        SerializeandDeserializeBST deserializeBST = new SerializeandDeserializeBST();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode node = deserializeBST.deserialize(deserializeBST.serialize(null));
        System.out.println(node);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        preOrder(builder, root);
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        if (data.length() <= 0) {
            return root;
        }
        String[] num = data.split(",");
        for (int i = 0; i < num.length; i++) {
            root = addItem(root, Integer.parseInt(num[i]));
        }
        return root;
    }

    private void preOrder(StringBuilder data, TreeNode node) {
        if (node == null) {
            return;
        }
        data.append(node.val + ",");
        preOrder(data, node.left);
        preOrder(data, node.right);
    }

    private TreeNode addItem(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }
        TreeNode temp;
        if (data <= root.val) {
            temp = addItem(root.left, data);
            root.left = temp;
        } else {
            temp = addItem(root.right, data);
            root.right = temp;
        }
        return root;
    }
}
