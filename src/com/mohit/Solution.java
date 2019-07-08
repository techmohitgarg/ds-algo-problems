package com.mohit;

import com.mohit.linklist.ListNode;
import com.mohit.linklist.PrintLinkList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        PrintLinkList.print(main.deleteDuplicates(node));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode prev = new ListNode(-1);
        prev.next = head;

        ListNode curr = head;
        while (curr != null) {
            while (curr != null && prev.val == curr.next.val) {
                curr = curr.next;
            }
            if (prev.val != curr.val) {
                prev = prev.next;
            } else {
                prev = curr;
            }
            curr = prev;
        }
        return head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        HashMap<Integer, Integer> set = new HashMap<>();
        ListNode iter = head;

        while (iter != null) {
            set.put(iter.val, set.getOrDefault(iter.val, 0) + 1);
            iter = iter.next;
        }
        ListNode node = new ListNode(0);
        ListNode listNode = node;


        iter = head;
        while (iter != null) {
            if (set.get(iter.val) == 1) {
                listNode.next = new ListNode(iter.val);
                listNode = listNode.next;
            }
            iter = iter.next;
        }

        return node.next;
    }
}
