package com.mohit.leetcode.linklist.medium;

import com.mohit.leetcode.linklist.ListNode;
import com.mohit.leetcode.linklist.PrintLinkList;

public class NextGreaterNodeInLinkedList {

    public static void main(String[] args) {
        NextGreaterNodeInLinkedList main = new NextGreaterNodeInLinkedList();
        ListNode one = new ListNode(2);
        one.next = new ListNode(1);
        one.next.next = new ListNode(5);


        main.nextLargerNodes(one);
    }


    public int[] nextLargerNodes(ListNode head) {
        if (head == null) return new int[0];
        ListNode itr = head;
        int len = 0;
        while (itr != null) {
            itr = itr.next;
            len++;
        }
        int[] num = new int[len];
        itr = head;

        int i = 0;
        while (itr != null && i < len) {
            ListNode next = itr.next;
            int val = itr.val;
            while (itr.next != null && itr.next.val <= val) {
                itr = itr.next;
            }
            if (itr.next != null && itr.next.val > val) {
                num[i] = itr.next.val;
            }
            i++;
            itr = next;
        }
        return num;
    }

    /*public int[] nextLargerNodes(ListNode head) {
        if (head == null) return new int[0];
        ListNode itr = head;
        int len = 0;
        while (itr != null) {
            itr = itr.next;
            len++;
        }
        int[] num = new int[len];
        itr = head;
        for (int i = 0; i < len && itr != null; i++) {
            num[i] = itr.val;
            itr = itr.next;
        }

        for (int i = 0; i < num.length; i++) {
            int temp = num[i];
            num[i] = 0;
            int j = i + 1;
            while (j < len && num[j] <= temp) {
                j++;
            }
            if (j < len && num[j] > temp) num[i] = num[j];

        }
        return num;

    }*/

}
