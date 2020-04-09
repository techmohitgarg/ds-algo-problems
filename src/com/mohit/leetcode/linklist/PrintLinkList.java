package com.mohit.leetcode.linklist;

import com.mohit.Solution;

public class PrintLinkList {

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();

    }
}
