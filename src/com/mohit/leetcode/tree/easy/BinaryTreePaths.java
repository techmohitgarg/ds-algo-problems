package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public static void main(String[] args) {
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.right = new TreeNode(5);
        System.out.println(binaryTreePaths.binaryTreePaths(tree));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        printPaths(paths, "", root);
        return paths;
    }

    private void printPaths(List<String> paths, String pathToLeaf, TreeNode root) {
        if (root == null) return;
        // Add the value in the array
        pathToLeaf += root.val;
        // if the both child node is null means path has been completed
        if (root.left == null && root.right == null) {
            paths.add(pathToLeaf);
        }
        // Move the array left side
        printPaths(paths, pathToLeaf + "->", root.left);
        // Move the array Right side
        printPaths(paths, pathToLeaf + "->", root.right);
    }

    //region Binary Tree Paths
    /*public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        findPathRootToleaf(root, paths, new ArrayList<>());
        return paths;
    }

    private void findPathRootToleaf(TreeNode root, List<String> pathList, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (i = 0; i < list.size() - 1; i++) {
                sb.append(list.get(i));
                sb.append("->");
            }
            sb.append(list.get(i));
            pathList.add(sb.toString());
        }

        findPathRootToleaf(root.left, pathList, list);
        findPathRootToleaf(root.right, pathList, list);
        list.remove(list.size() - 1);
    }*/

    //endregion

}
