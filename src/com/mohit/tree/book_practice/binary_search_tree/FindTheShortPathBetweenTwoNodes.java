package com.mohit.tree.book_practice.binary_search_tree;

import com.mohit.tree.book_practice.binary_tree.TreeNode;


public class FindTheShortPathBetweenTwoNodes {

    public static void main(String[] s) {
        int[] arr = {10, 5, 15, 30, 25, 35};
        FindTheShortPathBetweenTwoNodes searchTrees = new FindTheShortPathBetweenTwoNodes();
        TreeNode root = null;
        for (int i = 0; i < arr.length; i++) {
            root = searchTrees.addItem(root, arr[i]);
        }
        int a = 5;
        int b = 30;
        System.out.println(searchTrees.shortPath(root, a, b));
    }

    public TreeNode addItem(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }
        TreeNode temp;
        if (data <= root.val) {
            temp = addItem(root.left, data);
            root.left = temp;
        } else {
            temp = addItem(root.right, data);
            root.right = temp;
        }
        return root;
    }


    public int distanceFromRoot(TreeNode node, int data) {
        if (node.val == data) {
            return 0;
        } else if (node.val > data) {
            return 1 + distanceFromRoot(node.left, data);
        }
        return 1 + distanceFromRoot(node.right, data);
    }


    public int shortPath(TreeNode root, int a, int b) {
        if (root == null) {
            return 0;
        }
        if (root.val > a && root.val > b) {
            return shortPath(root.left, a, b);
        }
        if (root.val < a && root.val < b) {
            return shortPath(root.right, a, b);
        }

        if (root.val >= a && root.val <= b)
            return distanceFromRoot(root, a) +
                    distanceFromRoot(root, b);

        return 0;
    }


}
