package com.mohit.leetcode.linklist.easy;

import com.mohit.leetcode.linklist.ListNode;
import com.mohit.leetcode.linklist.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static com.mohit.leetcode.linklist.LinkedUtil.print;

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
        print(lists.getIntersectionNode(headA, headB));

    }


    public ListNode getIntersectionNode__(ListNode headA, ListNode headB) {

        ListNode a1 = headA;
        while (a1 != null) {

            ListNode b1 = headB;
            while (b1 != null) {

                if (b1 == a1) return b1;

                b1 = b1.next;
            }
            a1 = a1.next;
        }


        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode a1 = headA;
        while (a1 != null) {
            set.add(a1);
            a1 = a1.next;
        }

        if (set.isEmpty()) return null;
        ListNode b1 = headB;
        while (b1 != null) {
            if (set.contains(b1)) return b1;
            b1 = b1.next;
        }

        return null;
    }


    public ListNode getIntersectionNode_(ListNode headA, ListNode headB) {
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

    public Node findIntersection(Node headA, Node headB) {
        HashMap<Integer, Integer> set = new HashMap<>();
        Node a1 = headA;
        while (a1 != null) {
            set.put(a1.data, set.getOrDefault(a1.data, 0) + 1);
            a1 = a1.next;
        }

        if (set.isEmpty()) return null;
        Node b1 = headB;
        Node head = new Node(0);
        Node itr = head;

        while (b1 != null) {
            if (set.containsKey(b1.data) && set.get(b1.data) > 0) {
                itr.next = new Node(b1.data);
                itr = itr.next;
                set.put(b1.data, set.getOrDefault(b1.data, 0) - 1);
            }
            b1 = b1.next;
        }

        return head.next;
    }
}
