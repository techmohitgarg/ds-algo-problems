package com.mohit;

import com.mohit.tree.book_practice.binary_tree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class TreeBookPractice {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);

        a.left.left = new TreeNode(4);
        a.left.right = new TreeNode(5);

        a.right.left = new TreeNode(6);
        a.right.right = new TreeNode(7);

        TreeNode node = null;
        for (int i = 1; i <= 10; i++) {
            node = new TreeBookPractice().insert(node, i);
        }
        System.out.println(node);
    }
    //Give an algorithm	for	inserting	an	element	into binary	tree

    public TreeNode insert(TreeNode root, int data) {


        return root;
    }


    //Give	an	algorithm	for	searching	an	element	in	binary	tree
    public boolean find(TreeNode root, int val) {
        if (root == null) {
            return false;
        }
        if (root.val == val) return true;
        return find(root.left, val) || find(root.right, val);
    }

    //  Give an	algorithm	for	finding	maximum	element	in	binary	tree
    public int findMax(TreeNode node) {
        int max = Integer.MIN_VALUE;
        if (node != null) {
            max = node.val;
            int left = findMax(node.left);
            int right = findMax(node.right);
            max = Math.max(max, Math.max(left, right));
        }
        return max;
    }

    public int findMaxWithOutRecursion(TreeNode node) {
        int max = Integer.MIN_VALUE;
        if (node == null) return max;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            max = Math.max(max, temp.val);
            if (temp.left != null) stack.push(temp.left);
            if (temp.right != null) stack.push(temp.right);
        }
        return max;
    }


}
