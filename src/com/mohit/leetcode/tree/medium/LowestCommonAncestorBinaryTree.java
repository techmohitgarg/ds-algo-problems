package com.mohit.leetcode.tree.medium;

import com.mohit.TreeBookPractice;
import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorBinaryTree {

    public static void main(String[] s) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        //TreeNode reslt1 = new LowestCommonAncestorBinaryTree().lowestCommonAncestor(MakeTree.stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]"), a, b);
        TreeNode reslt1 = new LowestCommonAncestorBinaryTree().lowestCommonAncestor(MakeTree.stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]"), a, b);
        System.out.println(reslt1 == null ? "null" : reslt1.val);

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else {
            return (left != null ? left : right);
        }
    }

    /*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return null;
        }

        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        if (!printAllAncestors(path1, root, a) || !printAllAncestors(path2, root, b)) {
            return null;
        }
        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }
        return path1.get(i - 1);
    }

    private boolean printAllAncestors(List<TreeNode> list, TreeNode node, TreeNode val) {
        if (node == null) return false;


        list.add(node);
        if (node.val == val.val) return true;

        if (printAllAncestors(list, node.left, val) ||
                printAllAncestors(list, node.right, val)) return true;


        list.remove(list.size() - 1);
        return false;

    }*/


}
