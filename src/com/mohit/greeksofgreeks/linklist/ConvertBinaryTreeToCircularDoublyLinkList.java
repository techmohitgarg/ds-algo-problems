package com.mohit.greeksofgreeks.linklist;

public class ConvertBinaryTreeToCircularDoublyLinkList {
    static ListNode head = null;
    ListNode tail = null;


    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode prev;

        public ListNode(int x) {
            val = x;
        }
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        ConvertBinaryTreeToCircularDoublyLinkList sol = new ConvertBinaryTreeToCircularDoublyLinkList();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);

        root.right = new TreeNode(15);
        root.right.left = new TreeNode(36);

        sol.getDLLFromBinaryTree(root);
    }


    public ListNode getDLLFromBinaryTree(TreeNode root) {
        if (root == null) return null;

        makeBinaryTreeToDLL(root);

        return head;
    }

    public void makeBinaryTreeToDLL(TreeNode root) {
        if (root == null) return;
        makeBinaryTreeToDLL(root.left);
        circularLinkedList(root.val);
        makeBinaryTreeToDLL(root.right);
    }


    public void circularLinkedList(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        head.prev = tail;
        tail.next = head;
    }
}
