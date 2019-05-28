package com.mohit.linklist;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        SwapNodesInPairs nodes = new SwapNodesInPairs();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        PrintLinkList.print(nodes.swapPairs(l1));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode t = head.next;
        ListNode n = swapPairs(t.next);
        t.next = head;
        head.next = n;
        return t;
    }
}
