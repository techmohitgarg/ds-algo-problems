package com.mohit.leetcode.tree.medium;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.*;

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

    /*public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        findDuplication(root, treeNodeList, new HashMap<>());
        return treeNodeList;
    }

    public String findDuplication(TreeNode root, List<TreeNode> list, HashMap<String, Integer> subTreeValue) {
        if (root == null) return "";
        String subTree = "(";
        subTree += findDuplication(root.left, list, subTreeValue);
        subTree += root.val;
        subTree += findDuplication(root.right, list, subTreeValue);
        subTree += ")";

        if (subTreeValue.containsKey(subTree)) {
            if (subTreeValue.get(subTree) == 1) {
                System.out.println(subTree);
                list.add(root);
            }
        }
        subTreeValue.put(subTree, subTreeValue.getOrDefault(subTree, 0) + 1);
        return subTree;
    }*/


    /*ublic List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<TreeId, TreeId> subtrees = new HashMap<>();
        treeId(root, subtrees);
        List<TreeNode> duplicates = new ArrayList<>();
        for (TreeId id : subtrees.values()) {
            if (id.hasDuplicates()) {
                duplicates.add(id.node);
            }
        }
        return duplicates;
    }

    private static class TreeId {
        private final TreeId left, right;
        public final TreeNode node;
        private int count;

        public TreeId(TreeNode node, TreeId left, TreeId right) {
            this.node = node;
            this.left = left;
            this.right = right;
            this.count = 0;
        }

        public boolean hasDuplicates() {
            return count > 1;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof TreeId)) {
                return false;
            }
            TreeId other = (TreeId) o;
            return node.val == other.node.val && left == other.left && right == other.right;
        }

        @Override
        public int hashCode() {
            return Objects.hash(node.val, System.identityHashCode(left), System.identityHashCode(right));
        }
    }

    private static TreeId treeId(TreeNode tree, Map<TreeId, TreeId> subtrees) {
        if (tree == null) {
            return null;
        }
        TreeId key = new TreeId(tree, treeId(tree.left, subtrees), treeId(tree.right, subtrees));
        TreeId realId = subtrees.get(key);
        if (realId == null) {
            subtrees.put(key, key);
            realId = key;
        }
        ++realId.count;
        return realId;
    }*/

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
