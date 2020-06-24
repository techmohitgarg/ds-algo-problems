package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.*;

public class FindModeBinarySearchTree {

    public static void main(String[] s) {
        //[2,1,null,null,2,1,null,null,2]
        FindModeBinarySearchTree searchTree = new FindModeBinarySearchTree();
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(1);
        node.right.right = new TreeNode(2);

        System.out.println(searchTree.findMode(node));
    }

    int max = 0;
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        getMode(root, map);

        List<Integer> size = new ArrayList<>();
        for (Integer val : map.keySet()) {
            if (map.get(val) == max) {
                size.add(val);
            }
        }

        int[] nums = new int[size.size()];
        for (int i = 0; i < size.size(); i++) {
            nums[i] = size.get(i);
        }
        return nums;
    }


    public void getMode(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        if (map.containsKey(root.val)) {
            map.put(root.val, map.get(root.val) + 1);
        } else {
            map.put(root.val, 1);
        }
        max = Math.max(max, map.get(root.val));
        getMode(root.left, map);
        getMode(root.right, map);
    }

    //region Find Mode in Binary Search Tree
    /*public int[] findMode_(TreeNode root) {
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
                if (prev != null && prev.val == root.val) {
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
    }*/
    //endregion
}
