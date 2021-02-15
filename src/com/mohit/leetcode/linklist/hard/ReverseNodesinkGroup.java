package com.mohit.leetcode.linklist.hard;

import com.mohit.leetcode.linklist.ListNode;

import static com.mohit.leetcode.linklist.LinkedUtil.print;

public class ReverseNodesinkGroup {

    public static void main(String[] args) {
        ReverseNodesinkGroup group = new ReverseNodesinkGroup();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        print(group.reverseKGroup(l1, 2));
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (count < k) {
            if (cur == null) {
                return head;
            }
            cur = cur.next;
            count++;
        }

        ListNode pre = reverseKGroup(cur, k);
        while (count > 0) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
            count--;
        }
        return pre;
    }

    /*public ListNode reverseKGroup1(ListNode head, int k) {
        if (head == null) return head;

        int N = 0;
        ListNode itr = head;
        while (itr != null) {
            N++;
            itr = itr.next;
        }
        itr = head;

        int i = 0;
        ListNode list = new ListNode(-1);
        ListNode data = list;
        while (i < N - (N % k)) {
            int len = k;

            ListNode prev = null;
            ListNode next = null;
            while (len > 0 && itr != null) {
                next = itr.next;
                itr.next = prev;
                prev = itr;
                itr = next;
                len--;
                i++;
            }
            ListNode p = prev;
            while (p != null) {
                data.next = new ListNode(p.val);
                data = data.next;
                p = p.next;
            }
        }


        // add remaining list;
        data.next = itr;

        return list.next;

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }

        // get size
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }

        if (count < k) {
            return head;
        }

        cur = head;
        ListNode prev = null;
        ListNode next = null;
        ListNode group = new ListNode(0);
        ListNode listNode = group;
        int i = 0;
        while (i < (count / k)) {
            int j = k;
            while (cur != null && j > 0) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                if (listNode != null) {
                    listNode = listNode.next;
                }

                j--;
            }
            listNode.next = prev;
            prev = null;
            i++;
        }
        if (count % k != 0) {
            listNode.next = cur;

        }
        return group.next;
    }*/
}
