package com.mohit.leetcode.tree.medium;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.*;

public class ConstructBinaryTreeFromString {

    public static void main(String[] s) {
        TreeNode result = new ConstructBinaryTreeFromString().str2tree("-4(2(3)(1))(6(5))");
        System.out.println(result);
    }



    int i = 0;
    public TreeNode str2tree(String s) {
        if (i >= s.length()) return null;

        int val = 0;
        boolean flag = false;
        // Check if Negative true than set the flag to true
        if (s.charAt(i) == '-') {
            flag = true;
            i++;
        }
        while (i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
            val = 10 * val + (s.charAt(i) - '0');
            i++;
        }
        val = flag ? val * -1 : val;
        TreeNode node = new TreeNode(val);

        if (i < s.length() && s.charAt(i) == '(') {
            i++;
            node.left = str2tree(s);
            i++;
        }
        if (i < s.length() && s.charAt(i) == '(' && s.charAt(i - 1) == ')') {
            i++;
            node.right = str2tree(s);
            i++;
        }
        return node;
    }
}
