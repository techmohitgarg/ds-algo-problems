package com.mohit.leetcode.tree.medium;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPossibleFullBinaryTrees {

    public static void main(String[] args) {
        AllPossibleFullBinaryTrees fullBinaryTrees = new AllPossibleFullBinaryTrees();
        System.out.println(fullBinaryTrees.allPossibleFBT(5));
    }

    public List<TreeNode> allPossibleFBT(int N) {
        if (N == 0 || N % 2 == 0) {
            return new ArrayList<>();
        }
        List<TreeNode> list = new ArrayList<>();
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        list = addItem(map, N);
        return list;
    }

    public List<TreeNode> addItem(Map<Integer, List<TreeNode>> map, int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 1) {
            List<TreeNode> one = new ArrayList<>();
            TreeNode node = new TreeNode(0);
            one.add(node);
            map.put(1, one);
            return one;
        }
        List<TreeNode> list = new ArrayList<>();
        for (int i = 1; i <= n - 2; i += 2) {
            for (TreeNode left : addItem(map, i)) {
                for (TreeNode right : addItem(map, n - i - 1)) {
                    TreeNode node = new TreeNode(0);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }
        map.put(n, list);
        return list;
    }
}
