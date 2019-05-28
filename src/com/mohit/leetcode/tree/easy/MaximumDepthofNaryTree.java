package com.mohit.leetcode.tree.easy;

import java.util.List;

public class MaximumDepthofNaryTree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] s) {
        MaximumDepthofNaryTree naryTree = new MaximumDepthofNaryTree();

    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int size = root.children.size();
        int max = 1;
        for (int i = 0; i < size; i++) {
            max = Math.max(max, maxDepth(root.children.get(i)) + 1);

        }
        return max;
    }
}
