package com.mohit.leetcode.linklist.medium;

import com.mohit.leetcode.linklist.ListNode;

import java.util.HashMap;

public class LinkedListCycleII {

    public static void main(String[] args) {
        LinkedListCycleII cycle = new LinkedListCycleII();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        System.out.println(cycle.hasCycle(node));
    }

    public ListNode hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = slow;
        ListNode isFound = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                isFound = slow;
                break;
            }
        }

        ListNode iter = head;
        ListNode found = isFound;
        while (iter != null && found != null) {
            if (iter == found) {
                return iter;
            }
            iter = iter.next;
            found = found.next;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        HashMap<ListNode, ListNode> hashMap = new HashMap<>();
        while (fast != null) {
            if (hashMap.containsKey(fast)) {
                if (hashMap.get(fast) == fast) {
                    return hashMap.get(fast);
                }
            } else {
                hashMap.put(fast, fast);
            }
            fast = fast.next;
        }
        return null;
    }
}
