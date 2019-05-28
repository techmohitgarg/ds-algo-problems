package com.mohit.tree.book_practice.binary_search_tree;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class BinaryTreeBSTorNot {

    public static void main(String[] a) {
        BinaryTreeBSTorNot bsTorNot = new BinaryTreeBSTorNot();
        int[] arr = {20, 8, 22, 4, 12, 10, 14};
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        /*for (int i = 0; i < arr.length; i++) {
            root = bsTorNot.addItem(root, arr[i]);
        }*/

        System.out.println(bsTorNot.isBST(root));
        System.out.println(bsTorNot.isBST1(root));
        System.out.println(bsTorNot.isBST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(bsTorNot.isBST3(root));
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


    public boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val > root.val) {
            return false;
        }
        if (root.right != null && root.right.val < root.val) {
            return false;
        }
        return isBST(root.left) && isBST(root.right);
    }

    public boolean isBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && findMax(root.left) > root.val) {
            return false;
        }
        if (root.right != null && findMin(root.right) < root.val) {
            return false;
        }
        return isBST(root.left) && isBST(root.right);
    }

    public boolean isBST2(TreeNode root, int min, int max) {
        if (root == null)
            return true;
        if (root.val < min || root.val > max)
            return false;
        return (isBST2(root.left, min, root.val - 1) &&
                isBST2(root.right, root.val + 1, max));
    }

    int min = Integer.MIN_VALUE;

    public boolean isBST3(TreeNode root) {
        if (root == null)
            return true;
        if (!isBST3(root.left)) {
            return false;
        }
        if (root.val < min) {
            return false;
        }
        min = root.val;
        return isBST3(root.right);
    }

    public int findMin(TreeNode root) {
        if (root == null) {
            return -1;
        }

        if (root.left != null) {
            return findMin(root.left);
        }
        return root.val;
    }

    public int findMax(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.right != null) {
            return findMin(root.right);
        }
        return root.val;
    }

}
