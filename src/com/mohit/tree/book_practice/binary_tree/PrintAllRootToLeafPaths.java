package com.mohit.tree.book_practice.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class PrintAllRootToLeafPaths {

    public static void main(String[] args) {
        PrintAllRootToLeafPaths rootToLeafPaths = new PrintAllRootToLeafPaths();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.right = new TreeNode(5);
        rootToLeafPaths.paringAllLeafs(tree, new ArrayList<>());
    }

    public void paringAllLeafs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null) {
            print(list);
        }
        paringAllLeafs(root.left, list);
        paringAllLeafs(root.right, list);
        list.remove(list.size() - 1);
    }

    private void print(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(String.valueOf(list.get(i)) + " ");
        }
        System.out.println();
    }
}
