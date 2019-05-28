package com.mohit.linklist;


import java.util.*;

public class SortList {

    public static void main(String[] args) {
        SortList list = new SortList();
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(3);
        PrintLinkList.print(list.sortListUsingMerge(l1));

    }

    public ListNode sortList(ListNode head) {
        ArrayList<Integer> set = new ArrayList<>();

        ListNode iter = head;
        while (iter != null) {
            set.add(iter.val);
            iter = iter.next;

        }
        Collections.sort(set);
        ListNode node = new ListNode(0);
        ListNode listNode = node;
        for (int i = 0; i < set.size(); i++) {
            listNode.next = new ListNode(set.get(i));
            listNode = listNode.next;
        }
        return node.next;
    }

    public ListNode sortListUsingMerge(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // get Middle
        int count = 0;
        ListNode iter = head;
        while (iter != null) {
            iter = iter.next;
            count++;
        }

        int middle = count / 2;

        ListNode left = head;
        ListNode right = null;
        ListNode temp = head;
        while (iter != null) {
            middle--;
            ListNode next = temp.next;
            if (middle == 0) {
                temp.next = null;
                right = next;
            }

            temp = next;
        }
        ListNode h1 = sortList(left);
        ListNode h2 = sortList(right);
        ListNode merge = mergeTwoLists(h1, h2);
        return merge;
    }

    public ListNode sortListUsingMerge2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        // get center
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // check if both are empty
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode node = new ListNode(-1);
        ListNode iter = node;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                node.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            node = node.next;
        }
        while (l1 != null) {
            node.next = new ListNode(l1.val);
            l1 = l1.next;
            node = node.next;
        }
        while (l2 != null) {
            node.next = new ListNode(l2.val);
            l2 = l2.next;
            node = node.next;
        }
        return iter.next;
    }
}
