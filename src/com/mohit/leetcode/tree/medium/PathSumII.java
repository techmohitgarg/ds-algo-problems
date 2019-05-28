package com.mohit.leetcode.tree.medium;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public static void main(String[] args) {
        PathSumII sumII = new PathSumII();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(sumII.pathSum(root,22));
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> pathList = new ArrayList<>();
        pathSum(pathList, new ArrayList<>(), root, sum);
        return pathList;
    }

    public void pathSum(List<List<Integer>> pathList, List<Integer> list, TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            pathList.add(new ArrayList<>(list));
        }
        pathSum(pathList, list, root.left, sum - root.val);
        pathSum(pathList, list, root.right, sum - root.val);
        list.remove(list.size() - 1);
    }


}
