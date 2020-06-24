package com.mohit.leetcode.tree.medium;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.leetcode.tree.TreePracticeSolution;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {
    public static void main(String[] args) {

        FindLeavesOfBinaryTree sol = new FindLeavesOfBinaryTree();
        TreeNode root1 = MakeTree.stringToTreeNode("[5,3,6,2,4,null,7]");

    }

    //region Find Leaves of Binary Tree
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, root);
        return result;
    }

    private int helper(List<List<Integer>> list, TreeNode root) {
        if (root == null)
            return -1;

        int left = helper(list, root.left);
        int right = helper(list, root.right);
        int curr = Math.max(left, right) + 1;

        // the first time this code is reached is when curr==0,
        //since the tree is bottom-up processed.
        if (list.size() <= curr) {
            list.add(new ArrayList<Integer>());
        }

        list.get(curr).add(root.val);

        return curr;
    }


    /*public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> listOfLeaves = new ArrayList<>();
        if (root == null) return listOfLeaves;

        while (root != null) {
            List<Integer> list = new ArrayList<>();
            root = findLeavesList(list, root);
            listOfLeaves.add(list);
        }
        return listOfLeaves;
    }


    private TreeNode findLeavesList(List<Integer> list, TreeNode root) {
        if (root == null) return null;

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return null;
        }
        TreeNode left = findLeavesList(list, root.left);
        TreeNode right = findLeavesList(list, root.right);
        root.left = left;
        root.right = right;
        return root;
    }*/
    //endregion
}
