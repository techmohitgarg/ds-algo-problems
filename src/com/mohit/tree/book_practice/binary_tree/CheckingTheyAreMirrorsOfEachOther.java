package com.mohit.tree.book_practice.binary_tree;

public class CheckingTheyAreMirrorsOfEachOther {

    public static void main(String[] args) {
        CheckingTheyAreMirrorsOfEachOther areMirrorsOfEachOther = new CheckingTheyAreMirrorsOfEachOther();

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);
        a.left.right = new TreeNode(5);

        b.left = new TreeNode(3);
        b.right = new TreeNode(2);
        b.right.left = new TreeNode(5);
        b.right.right = new TreeNode(4);
        System.out.println(areMirrorsOfEachOther.isMirrorEachOther(a, b));
    }

    public boolean isMirrorEachOther(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isMirrorEachOther(root1.left, root2.right) && isMirrorEachOther(root1.right, root2.left);
    }
}
