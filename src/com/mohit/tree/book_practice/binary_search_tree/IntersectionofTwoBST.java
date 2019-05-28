package com.mohit.tree.book_practice.binary_search_tree;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IntersectionofTwoBST {

    public static void main(String[] args) {
        IntersectionofTwoBST twoBST = new IntersectionofTwoBST();

        int[] nums = {5, 1, 10, 0, 4, 7, 9};
        TreeNode t1 = new BinarySearchTree(nums).getBinaryTree();

        int[] nums_ = {10, 7, 20, 4, 9};
        TreeNode t2 = new BinarySearchTree(nums_).getBinaryTree();

        System.out.println(twoBST.getIntersectionList(t1, t2));
        System.out.println(twoBST.getIntersectionOfTwoTree(t1, t2));
    }


    public List<Integer> getIntersectionList(TreeNode t1, TreeNode t2) {
        List<Integer> list = new ArrayList<>();
        getIntersection(list, t1, t2);
        return list;
    }

    public void getIntersection(List<Integer> list, TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return;
        }
        getIntersection(list, t1, t2.left);
        getIntersection(list, t1, t2.right);
        if (isNodeExist(t1, t2)) {
            list.add(t2.val);
        }
    }

    public boolean isNodeExist(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (root.val == node.val) {
            return true;
        }
        if (root.val >= node.val) {
            return isNodeExist(root.left, node);
        }
        return isNodeExist(root.right, node);
    }


    public List<Integer> getIntersectionOfTwoTree(TreeNode t1, TreeNode t2) {
        List<Integer> list = new ArrayList<>();
        if (t1 != null && t2 != null) {
            Stack<TreeNode> root1 = new Stack<>();
            Stack<TreeNode> root2 = new Stack<>();
            while (true) {
                if (t1 != null) {
                    root1.push(t1);
                    t1 = t1.left;
                } else if (t2 != null) {
                    root2.push(t2);
                    t2 = t2.left;
                } else if (!root1.isEmpty() && !root2.isEmpty()) {
                    t1 = root1.peek();
                    t2 = root2.peek();
                    if (t1.val == t2.val) {
                        list.add(root1.peek().val);
                        root1.pop();
                        root2.pop();
                        t1 = t1.right;
                        t2 = t2.right;
                    } else if (t1.val < t2.val) {
                        root1.pop();
                        t1 = t1.right;
                        t2 = null;
                    } else if (t1.val < t2.val) {
                        root2.pop();
                        t2 = t2.right;
                        t1 = null;
                    }
                } else {
                    break;
                }
            }

        }
        return list;
    }
}
