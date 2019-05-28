package com.mohit.leetcode.tree.easy;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal {

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
        NaryTreePreorderTraversal traversal = new NaryTreePreorderTraversal();
    }


    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preOrderList(list, root);
        return list;
    }

    public void preOrderList(List<Integer> list, Node node) {
        if (node == null) {
            return;
        }

        list.add(node.val);
        for (int i = 0; i < node.children.size(); i++) {
            preOrderList(list, node.children.get(i));
        }
    }
}
