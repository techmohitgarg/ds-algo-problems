package com.mohit.greeksofgreeks.linklist;

import com.mohit.leetcode.linklist.LinkedUtil;
import com.mohit.leetcode.linklist.Node;

public class SearchElementInLinkedList {


    public static void main(String[] args) {
        SearchElementInLinkedList sol = new SearchElementInLinkedList();
        Node head = LinkedUtil.makeNode(new int[]{10, 12, 14, 15, 19, 20});
        System.out.println(sol.searchUsingIterative(head,1));
        System.out.println(sol.searchUsingRecursive(head,1));
    }


    public boolean searchUsingIterative(Node head, int x) {
        if (head == null) return false;

        while (head != null) {
            if (head.data == x) return true;

            head = head.next;
        }
        return false;
    }

    public boolean searchUsingRecursive(Node head, int x) {
        if (head == null) return false;

        if (head.data == x) return true;

        return searchUsingRecursive(head.next, x);
    }
}