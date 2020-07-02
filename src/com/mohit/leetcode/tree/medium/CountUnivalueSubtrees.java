package com.mohit.leetcode.tree.medium;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class CountUnivalueSubtrees {

    public static void main(String[] s) {
        CountUnivalueSubtrees addOneRowtoTree = new CountUnivalueSubtrees();
        TreeNode node = MakeTree.stringToTreeNode("[4,null,2,3,1]");
        int count = addOneRowtoTree.countUnivalSubtrees(node);
        System.out.println(count);
    }

    //region Count Univalue Subtrees
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        int left = countUnivalSubtrees(root.left);
        int right = countUnivalSubtrees(root.right);
        if (isSameValue(root)) {
            count++;
        }
        return count + left + right;
    }

    private boolean isSameValue(TreeNode root) {
        if (root == null) return true;

        if ((root.left != null && root.val != root.left.val) ||
                (root.right != null && root.val != root.right.val)) {
            return false;
        }

        return isSameValue(root.left) && isSameValue(root.right);
    }
    //endregion
}
