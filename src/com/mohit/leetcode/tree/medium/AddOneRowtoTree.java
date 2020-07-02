package com.mohit.leetcode.tree.medium;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowtoTree {

    public static void main(String[] s) {
        AddOneRowtoTree addOneRowtoTree = new AddOneRowtoTree();
        TreeNode node = MakeTree.stringToTreeNode("[4,null,2,3,1]");
        TreeNode treeNode = addOneRowtoTree.addOneRow(node, 1, 2);
        System.out.println(treeNode);
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) {
            return null;
        }
        return addOne(root, 0, v, d, true);
    }

    public TreeNode addOne(TreeNode root, int maxDepth, int v, int d, boolean b) {
        if (root == null) {
            if (maxDepth == d - 1) {
                TreeNode nodeNew = new TreeNode(v);
                return nodeNew;
            }
            return root;
        }

        if (maxDepth == d - 1) {
            TreeNode nodeNew = new TreeNode(v);
            if (b) {
                nodeNew.left = root;
            } else {
                nodeNew.right = root;
            }
            return nodeNew;
        }
        root.left = addOne(root.left, maxDepth + 1, v, d, true);
        root.right = addOne(root.right, maxDepth + 1, v, d, false);
        return root;
    }


    public TreeNode addOneRow1(TreeNode root, int v, int d) {
        if (root == null) return root;

        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int len = nodes.size();
            while (len > 0) {
                TreeNode data = nodes.poll();
                if (d > 2) {
                    if (data.left != null) nodes.add(data.left);
                    if (data.right != null) nodes.add(data.right);
                } else {
                    TreeNode left = new TreeNode(v);
                    TreeNode right = new TreeNode(v);
                    left.left = data.left;
                    right.right = data.right;

                    data.left = left;
                    data.right = right;
                }
                len--;
            }
            if (d <= 2) {
                break;
            }
            d--;
        }
        return root;
    }
}
