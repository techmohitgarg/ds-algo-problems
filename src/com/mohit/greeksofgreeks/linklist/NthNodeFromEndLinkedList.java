package com.mohit.greeksofgreeks.linklist;

import com.mohit.leetcode.linklist.LinkedUtil;
import com.mohit.leetcode.linklist.Node;

public class NthNodeFromEndLinkedList {

    public static void main(String[] args) {
        NthNodeFromEndLinkedList sol = new NthNodeFromEndLinkedList();
        Node head = LinkedUtil.makeNode(new int[]{1, 2});
        System.out.println(sol.getNthFromLast(head, 2));
    }


    int getNthFromLast(Node head, int n) {
        Node itr = head;
        int len = 0;
        while (itr != null) {
            ++len;
            itr = itr.next;
        }

        int lastNodeIndexIteration = len - n;
        itr = head;
        while (lastNodeIndexIteration > 0 && itr != null) {
            itr = itr.next;
            lastNodeIndexIteration--;
        }
        return itr == null || lastNodeIndexIteration < 0 ? -1 : itr.data;
    }

}