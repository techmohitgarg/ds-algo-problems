package com.mohit.leetcode.tree.easy;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal {

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
        NaryTreePostorderTraversal traversal = new NaryTreePostorderTraversal();
    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        postOrderList(list, root);
        return list;
    }

    public void postOrderList(List<Integer> list, Node node) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < node.children.size(); i++) {
            postOrderList(list, node.children.get(i));
        }
        list.add(node.val);
    }
}
