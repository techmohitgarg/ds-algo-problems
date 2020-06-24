package com.mohit.leetcode.tree.medium;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.*;

public class SerializeandDeserializeBST {

    public static void main(String[] args) {
        SerializeandDeserializeBST deserializeBST = new SerializeandDeserializeBST();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode node = deserializeBST.deserialize(deserializeBST.serialize(null));
        System.out.println(node);
    }

    public String serialize(TreeNode root) {
        if (root == null) return "[]";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder("[");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null,");
                continue;
            }
            sb.append(node.val + ",");
            queue.add(node.left);
            queue.add(node.right);

        }

        if (sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.trim();
        data = data.substring(1, data.length() - 1);
        if (data.length() == 0) {
            return null;
        }

        String[] parts = data.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    //region Serialize and Deserialize BST
    /*public static class Codec {
        public String serialize(TreeNode root) {
            if (root == null) return "null ";
            String out = root.val + " ";
            out += serialize(root.left);
            out += serialize(root.right);
            return out;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            List<String> list = Arrays.asList(data.split(" "));
            return helper(list.iterator());
        }

        private TreeNode helper(Iterator<String> itr) {
            if (itr == null || !itr.hasNext()) {
                return null;
            }

            String val = itr.next().trim();
            if (val.equals("null")) {
                return null;
            }

            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = helper(itr);
            node.right = helper(itr);
            return node;
        }
    }*/
    //endregion
}
