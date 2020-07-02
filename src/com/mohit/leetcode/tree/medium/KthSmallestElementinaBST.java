package com.mohit.leetcode.tree.medium;

import com.mohit.tree.book_practice.binary_search_tree.BinarySearchTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class KthSmallestElementinaBST {

    public static void main(String[] args) {
        KthSmallestElementinaBST minimunNumber = new KthSmallestElementinaBST();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        TreeNode tree = new BinarySearchTree(nums).getBinaryTree();
        minimunNumber.findKMin(tree, 3);
        System.out.println(minimunNumber.findKMinNode(tree, 3).val);

    }


    public void findKMin(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return;
        }
        if (k == 1) {
            System.out.println(root.val);
        }
        findKMin(root.left, k);
        k--;
        findKMin(root.right, k);
    }

    public TreeNode findKMinNode(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        if (k == 1) {
            return root;
        }
        TreeNode left = findKMinNode(root.left, k);
        if (left != null) {
            return left;
        }
        k--;
        return findKMinNode(root.right, k);
    }

    public int kthsmallest(TreeNode A, int B) {
        if (A == null) {
            return -1;
        }
        return findKMinNode(A, B).val;
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        TreeNode node = findKMinNode(root, k);
        return node == null ? -1 : node.val;
    }

    //region Kth Smallest Element in a BST
    /*int kIdx = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;

        int left = kthSmallest(root.left, k);

        if (left != -1) {
            return left;
        }
        kIdx++;
        if (kIdx == k) return root.val;

        return kthSmallest(root.right, k);

    }
   *//* public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        Stack<TreeNode> nodes = new Stack<>();
        while (true) {
            if (root != null) {
                nodes.push(root);
                root = root.left;
            } else {
                if (nodes.isEmpty()) return -1;
                k--;
                root = nodes.pop();
                if (k == 0) return root.val;

                root = root.right;
            }
        }
    }*/
    //endregion
}
