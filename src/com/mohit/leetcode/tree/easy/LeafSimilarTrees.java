package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeafSimilarTrees {

    public static void main(String[] s) {
        LeafSimilarTrees similarTrees = new LeafSimilarTrees();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(similarTrees.leafSimilar(root, root));
    }


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorder(list1, root1);
        inorder(list2, root2);
        int i = 0;
        for (i = 0; i < list1.size() && i < list2.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        if (i < list1.size() || i < list2.size()) {
            return false;
        }
        return true;
    }

    private void inorder(List<Integer> list1, TreeNode root1) {
        if (root1 == null) {
            return;
        }

        inorder(list1, root1.left);
        inorder(list1, root1.right);
        if (root1.left == null && root1.right == null) {
            list1.add(root1.val);
        }
    }
/*    //region Leaf-Similar Trees
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Queue<Integer> stack = new LinkedList<>();

        addLeafsNode(root1, stack, true);

        if (!addLeafsNode(root2, stack, false)) {
            return false;
        }
        return stack.isEmpty() ? true : false;
    }

    private boolean addLeafsNode(TreeNode root, Queue<Integer> stack, boolean isAdd) {
        if (root == null) return true;

        if (root.left == null && root.right == null) {
            if (isAdd) {
                stack.add(root.val);
                return true;
            } else {
                if (stack.isEmpty() || stack.peek() != root.val) {
                    return false;
                } else {
                    stack.poll();
                    return true;
                }
            }

        }
        return addLeafsNode(root.left, stack, isAdd) && addLeafsNode(root.right, stack, isAdd);
    }*/
}
