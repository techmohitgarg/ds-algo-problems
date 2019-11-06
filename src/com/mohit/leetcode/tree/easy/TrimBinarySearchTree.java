package com.mohit.leetcode.tree.easy;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.List;

public class TrimBinarySearchTree {

    public static void main(String[] s) {
        //[3,0,4,null,2,null,null,1]
        //1
        //3
        TrimBinarySearchTree bst = new TrimBinarySearchTree();
        TreeNode root = MakeTree.stringToTreeNode("[1,0,2]");
        System.out.println(bst.trimBST(root, 1, 2));
    }


    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }

        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        if (root.val > L) {
            return trimBST(root.right, L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public void inOrder(List<Integer> list, TreeNode root, int L, int R) {
        if (root == null) {
            return;
        }
        if (root.val >= L && root.val <= R) {
            list.add(root.val);
        }
        inOrder(list, root.left, L, R);
        inOrder(list, root.right, L, R);
    }


    private TreeNode addItem(TreeNode root, int data) {
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

}
