package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

}
