package com.mohit.tree.book_practice.binary_tree;

public class SiblingTreeNode {
    public int val;
    public SiblingTreeNode left;
    public SiblingTreeNode right;
    public SiblingTreeNode SiblingNode;

    public SiblingTreeNode(int x) {
        val = x;
        left = null;
        right = null;
        SiblingNode = null;
    }
}