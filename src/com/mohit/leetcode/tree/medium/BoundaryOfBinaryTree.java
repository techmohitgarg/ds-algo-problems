package com.mohit.leetcode.tree.medium;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.*;

public class BoundaryOfBinaryTree {

    public static void main(String[] s) {
        BoundaryOfBinaryTree addOneRowtoTree = new BoundaryOfBinaryTree();
        TreeNode node = MakeTree.stringToTreeNode("[1,2,3,4,5,6,#,#,#,7,8,9,10]".replace("#", "null"));
        List<Integer> treeNode = addOneRowtoTree.boundaryOfBinaryTree(node);
        System.out.println(treeNode);
    }

    //Iterative Boundary Traversal of Complete Binary tree
    public List<Integer> boundaryOfCompleteBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        // add root
        if (root.left == null && root.right == null) {
            return list;
        }

        TreeNode left = root.left;
        while (left.left != null) {
            list.add(left.val);
            left = left.left;
        }

        leafBoundary(root, list);


        TreeNode right = root.right;
        List<Integer> rightList = new ArrayList<>();
        while (right.right != null) {
            rightList.add(0, right.val);
            right = right.right;
        }

        list.add(root.val);

        return list;
    }


    //[1,2,4,7,8,9,10,6,3]
    //region Binary Tree Longest Consecutive Sequence
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        list.add(root.val);
        leftSideBoundary(root.left, list);
        leafBoundary(root, list);
        List<Integer> rightList = new ArrayList<>();
        rightSideBoundary(root.right, rightList);
        list.addAll(rightList);

        return list;
    }


    public void leftSideBoundary(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left != null) {
            list.add(root.val);
            leftSideBoundary(root.left, list);
        } else if (root.right != null) {
            list.add(root.val);
            leftSideBoundary(root.right, list);
        }
    }

    public void leafBoundary(TreeNode root, List<Integer> list) {
        if (root == null) return;

        leafBoundary(root.left, list);
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        leafBoundary(root.right, list);
    }

    public void rightSideBoundary(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.right != null) {
            list.add(0, root.val);
            rightSideBoundary(root.right, list);
        } else if (root.left != null) {
            list.add(0, root.val);
            rightSideBoundary(root.left, list);
        }
    }

    //endregion
}
