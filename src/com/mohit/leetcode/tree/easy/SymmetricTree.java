package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    public static void main(String[] args) {
        SymmetricTree tree = new SymmetricTree();
        TreeNode treeOne = new TreeNode(1);
        treeOne.left = new TreeNode(2);
        treeOne.right = new TreeNode(2);
        treeOne.left.left = new TreeNode(3);
        treeOne.left.right = new TreeNode(4);
        treeOne.right.left = new TreeNode(4);
        treeOne.right.right = new TreeNode(3);
        System.out.println(tree.isSymmetric(treeOne));
        System.out.println(tree.isSymmetric1(treeOne));
    }

    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirrorEachOther(root.left, root.right);
    }

    public boolean isMirrorEachOther(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isMirrorEachOther(root1.left, root2.right) && isMirrorEachOther(root1.right, root2.left);
    }
}
