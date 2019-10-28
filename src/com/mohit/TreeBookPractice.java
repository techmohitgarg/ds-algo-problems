package com.mohit;

import com.mohit.tree.book_practice.binary_tree.FindingTheDiameterOfTheBinaryTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

public class TreeBookPractice {


    public static void main(String[] args) {
        //[1,2,3,4,null,5]
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(4);
        //node.right.left = new TreeNode(5);

        System.out.println(new TreeBookPractice().tree2str(node));
    }

    public String tree2str(TreeNode t) {
        if (t == null) return "";
        StringBuilder sb = new StringBuilder();
        // Add Node value here
        sb.append(t.val);
        //check if node has left sub-tree
        if (t.left != null) {
            sb.append("(");
            sb.append(tree2str(t.left));
            sb.append(")");
        }

        if (t.right != null) {
            if (t.left == null) {
                sb.append("()");
            }

            sb.append("(");
            sb.append(tree2str(t.right));
            sb.append(")");

        }
        return sb.toString();
    }


}
