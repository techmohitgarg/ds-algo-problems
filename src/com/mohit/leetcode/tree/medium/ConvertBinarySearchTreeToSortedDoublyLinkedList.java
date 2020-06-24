package com.mohit.leetcode.tree.medium;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.leetcode.tree.TreePracticeSolution;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    TreeNode lastNode = null;
    TreeNode head = null;

    public static void main(String[] args) {
        ConvertBinarySearchTreeToSortedDoublyLinkedList sol = new ConvertBinarySearchTreeToSortedDoublyLinkedList();
        TreeNode root1 = MakeTree.stringToTreeNode("[5,3,6,2,4,null,7]");

    }


    //region Convert Binary Search Tree to Sorted Doubly Linked List
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        convertBSTToDLL(root);

        // Joint the first and last node at the end
        if (head != null && lastNode != null) {
            head.left = lastNode;
            lastNode.right = head;
        }
        return head;
    }

    private void convertBSTToDLL(TreeNode root) {
        if (root == null) return;

        convertBSTToDLL(root.left);
        if (lastNode == null) {
            head = root;
        } else {
            root.left = lastNode;
            lastNode.right = root;
        }
        lastNode = root;
        convertBSTToDLL(root.right);
    }
    //endregion
}
