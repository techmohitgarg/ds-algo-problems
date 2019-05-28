package com.mohit.linklist;

public class IntersectionofTwoLinkedLists {
    public static void main(String[] args) {
        IntersectionofTwoLinkedLists lists = new IntersectionofTwoLinkedLists();

        ListNode headA = new ListNode(1);
        headA.next = new ListNode(3);
        headA.next.next = new ListNode(5);
        headA.next.next.next = new ListNode(7);
        headA.next.next.next.next = new ListNode(9);
        headA.next.next.next.next.next = new ListNode(11);
        headA.next.next.next.next.next.next = new ListNode(13);
        headA.next.next.next.next.next.next.next = new ListNode(15);
        headA.next.next.next.next.next.next.next.next = new ListNode(17);
        headA.next.next.next.next.next.next.next.next.next = new ListNode(19);
        headA.next.next.next.next.next.next.next.next.next.next = new ListNode(21);
        ListNode headB = new ListNode(21);
        PrintLinkList.print(lists.getIntersectionNode(headA, headB));

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode iterA = headA;
        ListNode iterB = headB;

        int a = 1;
        while (iterA.next != null) {
            iterA = iterA.next;
            a++;
        }
        int b = 1;
        while (iterB.next != null) {
            iterB = iterB.next;
            b++;
        }

        if (!iterA.equals(iterB)) {
            return null;
        }

        iterA = headA;
        iterB = headB;
        int diff = Math.abs(a - b);
        if (diff > 0) {
            if (a > b) {
                while (iterA != null && diff > 0) {
                    iterA = iterA.next;
                    diff--;
                }
            } else {
                while (iterB != null && diff > 0) {
                    iterB = iterB.next;
                    diff--;
                }
            }
        }

        while (!iterA.equals(iterB)) {
            iterA = iterA.next;
            iterB = iterB.next;
        }
        return iterA;
    }
}
