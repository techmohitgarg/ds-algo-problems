package com.mohit.leetcode.tree.easy;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class SumofRootToLeafBinaryNumbers {


    public static void main(String[] args) {
        TreeNode t1 = MakeTree.stringToTreeNode("[1,0,1,0,1,0,1]");
        System.out.println(new SumofRootToLeafBinaryNumbers().sumRootToLeaf(t1));
    }

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        sum = printGetAllPath("", root);
        return sum;
    }

    private int printGetAllPath(String binaryString, TreeNode root) {
        if (root == null) return 0;
        binaryString += root.val;
        int left = printGetAllPath(binaryString, root.left);
        int right = printGetAllPath(binaryString, root.right);
        int sum = 0;
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(binaryString, 2);
        }
        return sum + left + right;
    }

}