package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.HashMap;

public class TwoSumIVInputBST {

    public static void main(String[] s) {

        TwoSumIVInputBST bst = new TwoSumIVInputBST();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        System.out.println(bst.findTarget(root, 28));
    }


    public boolean findTarget(TreeNode root, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return isFindTarget(map, root, k);
    }


    public boolean isFindTarget(HashMap<Integer, Integer> map, TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        int val = root.val;
        if (map.containsKey(k - val)) {
            return true;
        }
        map.put(val, val);
        return isFindTarget(map, root.left, k) || isFindTarget(map, root.right, k);
    }
}
