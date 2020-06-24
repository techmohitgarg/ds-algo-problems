package com.mohit.leetcode.tree.medium;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class InorderSuccessorInBSTII {
    public static void main(String[] args) {
        InorderSuccessorInBSTII sol = new InorderSuccessorInBSTII();
        TreeNode root1 = MakeTree.stringToTreeNode("[5,3,6,2,4,null,7]");

    }


    public TreeNode inOrderSuccessorWithOutRoot(TreeNode root, TreeNode TreeNode) {
        if (TreeNode.right != null) {
            TreeNode temp = TreeNode.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        } else {
            TreeNode p = TreeNode.parent;
            while (p != null && p.right == TreeNode) {
                TreeNode = p;
                p = TreeNode.parent;
            }
            return p;
        }

    }

    
    //endregion
}
