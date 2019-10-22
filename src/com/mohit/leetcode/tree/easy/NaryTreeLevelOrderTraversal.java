package com.mohit.leetcode.tree.easy;

import com.mohit.TreeBookPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {

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


    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> integers = new ArrayList<>();
            while (len > 0) {
                Node current = queue.poll();
                integers.add(current.val);
                for (int i = 0; i < current.children.size(); i++) {
                    queue.add(current.children.get(i));
                }
                len--;
            }
            list.add(integers);
        }


        return list;

    }

    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        List<Integer> childData = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node != null) {
                childData.add(node.val);
                for (Node data : node.children) {
                    queue.add(data);
                }
            } else {
                if (childData.size() > 0)
                    list.add(new ArrayList<>(childData));

                childData.clear();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }


            }


        }
        return list;
    }
}
