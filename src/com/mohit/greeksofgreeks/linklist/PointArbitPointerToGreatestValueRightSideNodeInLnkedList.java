package com.mohit.greeksofgreeks.linklist;


public class PointArbitPointerToGreatestValueRightSideNodeInLnkedList {
    static class ListNode {
        int data;
        ListNode next, arbit;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        PointArbitPointerToGreatestValueRightSideNodeInLnkedList sol = new PointArbitPointerToGreatestValueRightSideNodeInLnkedList();
        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(10);
        sol.setNextGreaterArbitraryNumber(head);
        System.out.println(head);
    }


    public ListNode setNextGreaterArbitraryNumberUsingRecursion(ListNode head) {
        if (head == null) return null;
        ListNode maxNode = setNextGreaterArbitraryNumberUsingRecursion(head.next);
        head.arbit = maxNode;
        if (maxNode == null) {
            maxNode = head;
        } else {
            if (head.data > maxNode.data) {
                maxNode = head;
            }
        }
        return maxNode;
    }

    public ListNode setNextGreaterArbitraryNumber(ListNode head) {
        if (head == null) return null;

        // Reverse the list
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
        curr = head;
        ListNode maxNode = head;
        while (curr.next != null) {
            curr.next.arbit = maxNode;
            if (curr.next.data > maxNode.data) {
                maxNode = curr;
            }
            curr = curr.next;
        }


        // Reverse the list
        prev = null;
        curr = head;
        next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // Resign the list to head
        head = prev;

        return head;
    }


}

