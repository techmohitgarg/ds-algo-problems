package com.mohit.tree.book_practice.generic_trees;

public class TreeNode {
    public int val;
    public TreeNode nextnode;
    public TreeNode chileNode;

    public TreeNode(int x) {
        val = x;
        nextnode = chileNode = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getNextnode() {
        return nextnode;
    }

    public void setNextnode(TreeNode nextnode) {
        this.nextnode = nextnode;
    }

    public TreeNode getChileNode() {
        return chileNode;
    }

    public void setChileNode(TreeNode chileNode) {
        this.chileNode = chileNode;
    }
}