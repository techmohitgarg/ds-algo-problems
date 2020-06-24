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


    //region Trim a Binary Search Tree
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;

        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }

    /*public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        List<Integer> list = new ArrayList<>();

        itrTree(root, L, R, list);
        TreeNode node = null;
        for (int i = 0; i < list.size(); i++) {
            node = BST(node, list.get(i));
        }
        return node;
    }

    private void itrTree(TreeNode root, int L, int R, List<Integer> list) {
        if (root == null) return;
        if (root.val >= L && root.val <= R) {
            list.add(root.val);
        }
        itrTree(root.left, L, R, list);
        itrTree(root.right, L, R, list);
    }

    public TreeNode BST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (root.val >= val) {
            root.left = BST(root.left, val);
        } else {
            root.right = BST(root.right, val);
        }

        return root;
    }*/
    //endregion

}
