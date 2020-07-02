package com.mohit.leetcode.tree.medium;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.leetcode.tree.Node;
import com.mohit.leetcode.tree.TreePracticeSolution;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        NaryTreeLevelOrderTraversal sol = new NaryTreeLevelOrderTraversal();
        TreeNode root1 = MakeTree.stringToTreeNode("[5,3,6,2,4,null,7]");

    }
    //region N-ary Tree Level Order Traversal
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        levelOrder(root, list, 0);
        return list;
    }

    private void levelOrder(Node root, List<List<Integer>> list, int level) {
        if (root == null) return;
        if (list.size() <= level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        if (root.children != null && root.children.size() > 0) {
            level++;
            for (int i = 0; i < root.children.size(); i++) {
                levelOrder(root.children.get(i), list, level);
            }
        }
    }
    //endregion
}
