package com.mohit.leetcode.linklist.medium;

import com.mohit.leetcode.linklist.ListNode;

import static com.mohit.leetcode.linklist.LinkedUtil.print;

public class InsertionSortList {

    public static void main(String[] args) {
        InsertionSortList sortList = new InsertionSortList();
        ListNode l1 = new ListNode(6);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(1);
        l1.next.next.next.next = new ListNode(8);
        l1.next.next.next.next.next = new ListNode(7);
        l1.next.next.next.next.next.next = new ListNode(2);
        l1.next.next.next.next.next.next.next = new ListNode(4);
        print(sortList.insertionSortList(l1));
    }


    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode node = head;
        ListNode prev = new ListNode(0);
        ListNode listNode = prev;
        ListNode next;
        while (node != null) {
            next = node.next;
            while (listNode.next != null && listNode.next.val < node.val) {
                listNode = listNode.next;
            }

            node.next = listNode.next;
            listNode.next = node;
            listNode = prev;
            node = next;
        }

        return prev.next;
    }
    /*public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode node = head;
        ListNode prev = new ListNode(0);
        ListNode next;
        while (node != null) {
            next = node.next;
            ListNode listNode = prev;
            while (listNode.next != null && listNode.next.val < node.val) {
                listNode = listNode.next;
            }

            node.next = listNode.next;
            listNode.next = node;

            node = next;
        }

        return prev.next;
    }*/
 /*   public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;


        ListNode curr = head;
        ListNode sorted = new ListNode(0);
        ListNode prev = sorted;

        while (curr != null) {
            ListNode itr = prev;
            while (itr.next != null && itr.next.val < curr.val) {
                itr = itr.next;
            }
            ListNode temp = itr.next;
            itr.next = new ListNode(curr.val);
            itr.next.next = temp;
            curr=curr.next;
        }
        return sorted.next;
    }*/
}
