package com.mohit.linklist;

public class LinkedListCycle {

    public static void main(String[] args) {
        LinkedListCycle cycle = new LinkedListCycle();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        System.out.println(cycle.hasCycle(node));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = slow;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    public boolean hasCycle1(ListNode head) {
        ListNode slow = head;
        ListNode fast = slow;
        while (fast != null) {
            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
