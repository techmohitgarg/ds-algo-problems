package com.mohit.leetcode.linklist.medium;

import com.mohit.leetcode.linklist.LinkedUtil;
import com.mohit.leetcode.linklist.ListNode;

import java.util.HashMap;

import static com.mohit.leetcode.linklist.LinkedUtil.print;

public class SwappingNodesInLinkedList {

    public static void main(String[] args) {
        SwappingNodesInLinkedList sol = new SwappingNodesInLinkedList();
        ListNode head = LinkedUtil.makeListNode(new int[]{1, 2, 3, 4, 5});
        ListNode result = sol.swapNodes(head, 1);
        print(head);
        print(result);
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode itr = head;
        int len = 0;
        ListNode kStart = null;
        while (itr != null) {
            ++len;
            if (len == k) {
                kStart = itr;
            }
            itr = itr.next;
        }

        int iterationCount = len - k;

        if (iterationCount + 1 == k) return head;

        itr = head;
        while (iterationCount > 0) {
            itr = itr.next;
            iterationCount--;
        }
        int temp = kStart.val;
        kStart.val = itr.val;
        itr.val = temp;
        return head;
    }

    public ListNode swapNodes_(ListNode head, int k) {

        HashMap<Integer, ListNode> map = new HashMap<>();

        ListNode itr = head;
        int i = 0;
        while (itr != null) {
            map.put(++i, itr);
            itr = itr.next;
        }

        ListNode kStart = map.get(k);
        ListNode kEnd = map.get(i - k + 1);

        int temp = kStart.val;
        kStart.val = kEnd.val;
        kEnd.val = temp;
        return head;
    }

}