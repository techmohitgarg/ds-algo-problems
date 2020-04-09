package com.mohit.greeksofgreeks.linklist;


import com.mohit.leetcode.linklist.ListNode;
import com.mohit.leetcode.linklist.PrintLinkList;

public class DeleteNNodesAfterMNodesLinkedList {

    public static void main(String[] args) {
        DeleteNNodesAfterMNodesLinkedList sol = new DeleteNNodesAfterMNodesLinkedList();
        ListNode head = sol.createList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10);
        sol.deleteNNodesAfterMNodesOfLinkedList(head, 1, 1);
    }

    public ListNode createList(int arr[], int n) {
        ListNode node = null;
        ListNode p = null;

        int i;
        for (i = 0; i < n; ++i) {
            if (node == null) {
                node = p = new ListNode(arr[i]);
            } else {
                p.next = new ListNode(arr[i]);
                p = p.next;
            }
        }
        return node;
    }

    public void deleteNNodesAfterMNodesOfLinkedList(ListNode head, int m, int n) {
        if (head == null) return;

        ListNode curr = head;
        while (curr != null) {
            // Retain the nodes
            for (int i = 0; i < m - 1 && curr != null; i++) {
                curr = curr.next;
            }


            for (int i = 0; i < n && curr != null && curr.next != null; i++) {
                ListNode prev = curr.next;
                curr.next = curr.next.next;
                prev = null;
            }
             curr = curr.next;
        }
        PrintLinkList.print(head);

    }
}
