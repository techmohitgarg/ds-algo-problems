package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.Queue;

public class IncreasingOrderSearchTree {

    public static void main(String[] args) {
        IncreasingOrderSearchTree sol = new IncreasingOrderSearchTree();
    }

    //region Increasing Order Search Tree
    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }

//    public TreeNode increasingBST(TreeNode root) {
//        if (root == null) return null;
//
//        Queue<TreeNode> nodes = new LinkedList<>();
//        //Get the Nodes in Inorder Manner
//        inOrder(root, nodes);
//
//        // Assign the root=null;
//        root = new TreeNode(0);
//        TreeNode curr = root;
//        while (!nodes.isEmpty()) {
//            curr.right = new TreeNode(nodes.poll().val);
//            curr = curr.right;
//        }
//
//        /*// Assign the root=null;
//        root = null;
//        while (!nodes.isEmpty())
//            root = makeRightBinarySearchTree(root, nodes.poll().val);*/
//
//
//        return root.right;
//    }

    private TreeNode makeRightBinarySearchTree(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        root.left = null;
        root.right = makeRightBinarySearchTree(root.right, val);

        return root;
    }

    private void inOrder(TreeNode root, Queue<TreeNode> list) {
        if (root == null) return;

        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }
    //endregion
}
