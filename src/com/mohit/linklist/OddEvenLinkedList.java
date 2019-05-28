package com.mohit.linklist;

public class OddEvenLinkedList {

    public static void main(String[] args) {
        OddEvenLinkedList linkedList = new OddEvenLinkedList();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        PrintLinkList.print(linkedList.oddEvenList(l1));
    }


    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode node = even;
        while (odd != null && odd.next != null && node.next != null) {
            odd.next = odd.next.next;
            node.next = node.next.next;
            odd = odd.next;
            node = node.next;
        }
        odd.next = even;
        return head;
    }

    public ListNode oddEvenList1(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode odd = new ListNode(0);
        ListNode listNode1 = odd;
        ListNode even = new ListNode(0);
        ListNode listNode2 = even;

        ListNode iter = head;
        while (iter != null && iter.next != null) {
            listNode1.next = new ListNode(iter.val);
            listNode1 = listNode1.next;
            iter = iter.next;

            listNode2.next = new ListNode(iter.val);
            listNode2 = listNode2.next;
            iter = iter.next;
        }

        if (iter != null) {
            listNode1.next = new ListNode(iter.val);
            listNode1 = listNode1.next;
        }
        listNode1.next = even.next;
        return odd.next;
    }


}
