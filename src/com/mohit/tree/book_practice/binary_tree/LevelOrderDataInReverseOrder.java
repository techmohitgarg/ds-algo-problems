package com.mohit.tree.book_practice.binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderDataInReverseOrder {

    public static void main(String[] args) {
        LevelOrderDataInReverseOrder inReverseOrder = new LevelOrderDataInReverseOrder();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        inReverseOrder.printInReveseOrder(tree);
    }

    //Time	Complexity:	O(n).	Space	Complexity:	O(n).
    public void printInReveseOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(node);
        while (!nodes.isEmpty()) {
            TreeNode temp = nodes.poll();
            if (temp.right != null) {
                nodes.add(temp.right);
            }
            if (temp.left != null) {
                nodes.add(temp.left);
            }
            nodeStack.push(temp);
        }
        System.out.print("[");
        while (!nodeStack.isEmpty()) {
            System.out.print(String.valueOf(nodeStack.pop().val) + ",");
        }
        System.out.print("]");
    }
}
