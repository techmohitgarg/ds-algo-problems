package com.mohit.leetcode.tree.easy;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class RangeSumofBST {


    public static void main(String[] args) {
        TreeNode t1 = MakeTree.stringToTreeNode("[10,5,15,3,7,13,18,1,null,6]");
        System.out.println(new RangeSumofBST().rangeSumBST(t1, 6, 10));
    }

    //region Range Sum of BST
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        int count = 0;
        if (root.val >= L && root.val <= R) {
            count += root.val;
        }
        if (L < root.val) {
            count += rangeSumBST(root.left, L, R);
        }
        if (R > root.val) {
            count += rangeSumBST(root.right, L, R);
        }
        return count;
    }
    //endregion

}