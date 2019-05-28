package com.mohit.leetcode.tree.medium;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees {

    public static void main(String[] s) {
        FindDuplicateSubtrees subtrees = new FindDuplicateSubtrees();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        System.out.println(subtrees.findDuplicateSubtrees(root));
    }


    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> list = new ArrayList<>();
        HashMap<String, List<TreeNode>> map = new HashMap<>();
        getNoddesOfList(root, map);

        for (String key : map.keySet()) {
            List<TreeNode> nodeList = map.get(key);
            if (nodeList.size() >= 2) {
                list.add(nodeList.get(0));
            }
        }
        return list;
    }

    public String getNoddesOfList(TreeNode root, HashMap<String, List<TreeNode>> map) {
        if (root == null) {
            return ",";
        }
        String left = getNoddesOfList(root.left, map);
        String right = getNoddesOfList(root.right, map);
        String key = root.val + ":" + left + ":" + right;
        List<TreeNode> list = map.getOrDefault(key, new ArrayList<>());
        list.add(root);
        map.put(key, list);
        return key;
    }
}
