package com.mohit.leetcode.tree.easy;


import com.mohit.leetcode.tree.MakeTree;
import com.mohit.leetcode.tree.TreePracticeSolution;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.*;

public class FindModefBST {


    public static void main(String[] args) {
        FindModefBST sol = new FindModefBST();
        TreeNode root = MakeTree.stringToTreeNode("[1,3,2,null,null,4]");
        int sum = 3;
        sol.findMode(root);
    }

    public int[] findMode_(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        countAllTheNumber(root, list);
        int[] data = new int[list.size()];
        for (int i = 0; i < data.length; i++) {
            data[i] = list.get(i);
        }
        return data;
    }
    private int countAllTheNumber(TreeNode root, ArrayList<Integer> integers) {
        if (root == null) return 0;
        Stack<TreeNode> nodes = new Stack<>();
        int maxCount = 0;
        TreeNode prev = null;
        int count = 0;
        while (true) {
            if (root != null) {
                nodes.push(root);
                root = root.left;
            } else {
                if (nodes.isEmpty()) break;
                root = nodes.pop();
                if (prev != null&&prev.val == root.val) {
                    count += 1;
                } else {
                    count = 1;
                }
                if (count > maxCount) {
                    integers.clear();
                    maxCount = count;
                    integers.add(root.val);
                } else if (count == maxCount) {
                    integers.add(root.val);
                }
                prev = root;
                root = root.right;

            }

        }
        return maxCount;
    }

    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxCount = countAllTheNumber(root, map);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            if (set.getValue() == maxCount) {
                list.add(set.getKey());
            }
        }
        int[] data = new int[list.size()];
        for (int i = 0; i < data.length; i++) {
            data[i] = list.get(i);
        }
        return data;
    }

    private int countAllTheNumber(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) return 0;
        int left = countAllTheNumber(root.left, map);
        int right = countAllTheNumber(root.right, map);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        int maxCount = Math.max(Math.max(left, right), map.get(root.val));
        return maxCount;
    }


}