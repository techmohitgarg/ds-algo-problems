package com.mohit;

import com.mohit.linklist.ListNode;
import com.mohit.linklist.PrintLinkList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        //node.next.next.next.next = new ListNode(5);
        main.reorderList(node);
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        node = head;
        int i = 0;
        while (i < list.size() / 2) {
            node.val = list.get(i);
            node = node.next;
            node.val = list.get(list.size() - i - 1);
            node = node.next;
            i++;
        }
        if (list.size() % 2 != 0) {
            node.val = list.get(i);
        }

        PrintLinkList.print(head);
    }
}
