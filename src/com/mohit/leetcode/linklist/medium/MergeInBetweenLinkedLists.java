package com.mohit.leetcode.linklist.medium;

import com.mohit.leetcode.linklist.LinkedUtil;
import com.mohit.leetcode.linklist.ListNode;

public class MergeInBetweenLinkedLists {

    public static void main(String[] args) {
        MergeInBetweenLinkedLists sol = new MergeInBetweenLinkedLists();
        ListNode list1 = LinkedUtil.makeListNode(new int[]{0, 1, 2, 3, 4, 5});
        ListNode list2 = LinkedUtil.makeListNode(new int[]{1000000, 1000001, 1000002});

        ListNode result = sol.mergeInBetween(list1, 2, 5, list2);
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if (list1 == null && list2 == null) return null;

        ListNode startNode = null;
        ListNode itr = list1;
        ListNode prev = null;
        int i = 0;
        while (itr != null) {
            if (i == a) {
                startNode = prev;
            }
            if (i == b) {
                break;
            }
            prev = itr;
            itr = itr.next;
            i++;
        }
        ListNode itr2 = list2;
        while (itr != null && itr2.next != null) {
            itr2 = itr2.next;
        }

        startNode.next = list2;
        itr2.next = itr.next;

        return list1;
    }


}