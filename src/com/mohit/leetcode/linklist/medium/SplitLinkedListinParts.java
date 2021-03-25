package com.mohit.leetcode.linklist.medium;

import com.mohit.leetcode.linklist.ListNode;

public class SplitLinkedListinParts {

    public static void main(String[] args) {
        SplitLinkedListinParts main = new SplitLinkedListinParts();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next = new ListNode(7);
        node.next.next.next.next.next.next.next = new ListNode(8);
        node.next.next.next.next.next.next.next.next = new ListNode(9);
        node.next.next.next.next.next.next.next.next.next = new ListNode(10);

        main.splitListToParts(null, 5);
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode itr = root;
        int len = 0;
        while (itr != null) {
            len++;
            itr = itr.next;
        }
        itr = root;
        ListNode[] nodes = new ListNode[k];
        int i = 0;
        int width = len / k;
        int reamin = len % k;
        while (itr != null) {
            int size = 0;
            size = (i < reamin) ? width + 1 : width;
            ListNode part = new ListNode(-1);
            ListNode val = part;
            while (itr != null && size > 0) {
                val.next = itr;
                val = val.next;
                itr = itr.next;
                val.next = null;
                size--;
            }
            nodes[i] = part.next;
            i++;
        }
        while (i < k) {
            nodes[i] = null;
            i++;
        }

        return nodes;
    }


    public ListNode[] splitListToParts1(ListNode root, int k) {
        ListNode[] listNodes = new ListNode[k];

        int len = size(root);

        int subSetLen = len / k;
        int remain = len % k;

        ListNode itr = root;

        int i = 0;
        while (i < k && itr != null) {
            int j = 0;
            int setLen = (i < remain) ? subSetLen + 1 : subSetLen;
            ListNode start = itr;
            ListNode prev = null;
            while (j < setLen && itr != null) {
                prev = itr;
                itr = itr.next;
                j++;
            }
            prev.next = null;
            listNodes[i] = start;
            i++;
        }
        return listNodes;
    }

    private int size(ListNode root) {
        int len = 0;
        ListNode itr = root;
        while (itr != null) {
            itr = itr.next;
            len++;
        }
        return len;
    }

}
