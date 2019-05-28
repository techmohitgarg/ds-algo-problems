package com.mohit.tree.book_practice.binary_search_tree;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class SortedDLLtoBalancedBST {


    public static void main(String[] s) {
        int[] num = {7, 6, 5, 4, 3, 2, 1};
        SortedDLLtoBalancedBST list = new SortedDLLtoBalancedBST();
        for (int i = 0; i < num.length; i++) {
            list.push(num[i]);
        }
        System.out.println("Given Linked List ");
        list.printList();

        /* Convert List to BST */
        System.out.println();
        System.out.println("Pre-Order Traversal of constructed BST ");
        list.preOrder(list.sortedListToBST());
        System.out.println();
        list.preOrder(list.sortedListToBST2());
    }

    static TreeNode head;

    /* Function to print nodes in a given linked list */
    void printList() {
        TreeNode node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.right;
        }
    }

    /* A utility function to print preorder traversal of BST */
    void preOrder(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //Make doubly linkList
    public void push(int data) {
        TreeNode tempNode = new TreeNode(data);
        tempNode.left = null;
        tempNode.right = head;
        if (head != null) {
            head.left = tempNode;
        }
        head = tempNode;
    }

    //Count the Linked List Size
    public int countNodes(TreeNode head) {
        TreeNode node = head;
        int count = 0;
        while (node != null) {
            node = node.right;
            count++;
        }
        return count;
    }


    public TreeNode sortedListToBSTRecur2(int[] head, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = (end + start) / 2;
        TreeNode root = new TreeNode(head[middle]);
        root.left = sortedListToBSTRecur2(head, start, middle - 1);
        root.right = sortedListToBSTRecur2(head, middle + 1, end);
        return root;
    }

    public TreeNode sortedListToBSTRecur1(TreeNode head, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = start + (end - start) / 2;
        TreeNode left = sortedListToBSTRecur1(head, start, middle - 1);
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        if (head.right != null) {
            head.val = head.right.val;
            head.right = head.right.right;
        }
        root.right = sortedListToBSTRecur1(head, middle + 1, end);
        return root;
    }

    public TreeNode sortedListToBSTRecur2(TreeNode head, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = (end + start) / 2;
        TreeNode left = sortedListToBSTRecur1(head, start, middle - 1);
        TreeNode root = new TreeNode();
        root.setVal(head.val);
        root.setLeft(left);
        head = head.getRight();
        root.setRight(sortedListToBSTRecur1(head, middle + 1, end));
        return root;
    }

    public TreeNode sortedListToBSTRecur(int n) {
        if (n <= 0)
            return null;
        TreeNode root = head;
        root.left = sortedListToBSTRecur(n / 2);
        head = head.right;
        root.right = sortedListToBSTRecur(n - n / 2 - 1);
        return root;
    }

    public TreeNode sortedListToBSTRecur1(int n) {
        if (n <= 0)
            return null;
        TreeNode left = sortedListToBSTRecur1(n / 2);
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        head = head.right;
        root.right = sortedListToBSTRecur1(n - n / 2 - 1);
        return root;
    }


    TreeNode sortedListToBST() {
        int n = countNodes(head);
        //return sortedListToBSTRecur(n);
        return sortedListToBSTRecur1(n);
    }

    TreeNode sortedListToBST1() {
        int n = countNodes(head);
        //return sortedListToBSTRecur1(head, 0, n - 1);
        return sortedListToBSTRecur2(head, 0, n - 1);
    }

    TreeNode sortedListToBST2() {
        int[] num = {1, 2, 3, 4, 5, 6, 7};
        return sortedListToBSTRecur2(num, 0, num.length - 1);
    }

}
