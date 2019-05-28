package com.mohit.tree.book_practice.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class FindingLCAOfTwoNodesInBinaryTree {

    public static void main(String[] s) {
        FindingLCAOfTwoNodesInBinaryTree lca = new FindingLCAOfTwoNodesInBinaryTree();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        System.out.println("LCA(4, 5): " + lca.findLCA(tree, new TreeNode(4), new TreeNode(5)));
        System.out.println("LCA(4, 6): " + lca.findLCA(tree, new TreeNode(4), new TreeNode(6)));
        System.out.println("LCA(3, 4): " + lca.findLCA(tree, new TreeNode(3), new TreeNode(4)));
        System.out.println("LCA(2, 4): " + lca.findLCA(tree, new TreeNode(2), new TreeNode(10)));

        System.out.println("LCA(4, 5): " + lca.LCA(tree, new TreeNode(4), new TreeNode(5)).val);
        System.out.println("LCA(4, 6): " + lca.LCA(tree, new TreeNode(4), new TreeNode(6)).val);
        System.out.println("LCA(3, 4): " + lca.LCA(tree, new TreeNode(3), new TreeNode(4)).val);
        System.out.println("LCA(2, 4): " + lca.LCA(tree, new TreeNode(2), new TreeNode(10)).val);
    }

    public TreeNode LCA(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return null;
        }

        if (root.val == a.val || root.val == b.val) {
            return root;
        }
        TreeNode left = LCA(root.left, a, b);
        TreeNode right = LCA(root.right, a, b);

        if (left != null && right != null) {
            return root;
        } else {
            return (left != null ? left : right);
        }

    }

    public int lca(TreeNode A, int B, int C) {
        return LCA(A, new TreeNode(B),new TreeNode(C)).val;
    }

    public int findLCA(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return -1;
        }

        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();
        if (!printAllAncestors(path1, root, a) || !printAllAncestors(path2, root, b)) {
            return -1;
        }
        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }
        return path1.get(i - 1);
    }

    public boolean printAllAncestors(List<Integer> list, TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        list.add(root.val);
        if (root.val == node.val) {
            return true;
        }
        if (printAllAncestors(list, root.left, node)
                || printAllAncestors(list, root.right, node)) {
            return true;
        }
        list.remove(list.size() - 1);
        return false;
    }
}
