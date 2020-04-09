package com.mohit;


import com.mohit.greeksofgreeks.linklist.FlattenMultilevelLinkedList;
import com.mohit.leetcode.linklist.ListNode;
import com.mohit.leetcode.linklist.PrintLinkList;
import com.mohit.leetcode.tree.Node;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.*;

public class Solution {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }



    public static void main(String[] args) {
        Solution sol = new Solution();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        sol.rearrange(head);

    }

    void rearrange(Node node) {

        // 1) Find the middle point using tortoise and hare method
        Node slow = node, fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2) Split the linked list in two halves
        // node1, head of first half    1 -> 2 -> 3
        // node2, head of second half   4 -> 5
        Node node1 = node;
        Node node2 = slow.next;
        slow.next = null;
    }


}
