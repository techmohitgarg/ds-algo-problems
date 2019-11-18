package com.mohit;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.leetcode.tree.Node;
import com.mohit.tree.book_practice.binary_tree.TreeNode;
import com.sun.source.tree.Tree;

import javax.swing.*;
import java.util.*;

public class TreeBookPractice {

    public static void main(String[] args) {
        TreeNode node = MakeTree.stringToTreeNode("[1,2,3,4,null,2,4,null,null,4]");
        new TreeBookPractice().findDuplicateSubtrees(node);
    }


    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        HashMap<String, Integer> map = new HashMap<>();
        listOfDuplicates(root, map, list);
        return list;
    }

    public String listOfDuplicates(TreeNode root, HashMap<String, Integer> map, List<TreeNode> list) {
        if (root == null) return "";
        String path = "(";
        path += listOfDuplicates(root.left, map, list);
        path += root.val;
        path += listOfDuplicates(root.right, map, list);
        path += ")";
        if (map.get(path) != null && map.get(path) == 1) {
            list.add(root);
        }
        map.put(path, map.getOrDefault(path, 0) + 1);

        return path;

    }

}