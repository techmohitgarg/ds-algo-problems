package com.mohit.tree.book_practice.binary_search_tree;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class FindKthMinimunNumber {

    public static void main(String[] args) {
        FindKthMinimunNumber minimunNumber = new FindKthMinimunNumber();
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

}
