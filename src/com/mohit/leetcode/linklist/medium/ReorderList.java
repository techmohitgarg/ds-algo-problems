package com.mohit.leetcode.linklist.medium;

import com.mohit.linklist.ListNode;
import com.mohit.linklist.PrintLinkList;

import java.util.HashMap;

public class ReorderList {

    public static void main(String[] args) {
        ReorderList list = new ReorderList();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        list.reorderList(l1);
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Add Node Data In HashMap
        HashMap<Integer, ListNode> hm = new HashMap<>();
        ListNode iter = head;
        int i = 0;
        while (iter != null) {
            hm.put(i, iter);
            iter = iter.next;
            i++;
        }
        //Modify List
        int left = 1;
        int right = i - 1;

        iter = head;
        while (left <= right && iter != null) {
            //Left
            iter.next = hm.get(right);
            iter = iter.next;
            iter.next = hm.get(left);
            iter = iter.next;
            left++;
            right--;
        }
        if (left > right) {
            iter.next = null;
        }
        PrintLinkList.print(head);
    }
}
