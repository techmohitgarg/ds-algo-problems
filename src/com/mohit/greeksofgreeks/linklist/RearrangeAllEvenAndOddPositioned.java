package com.mohit.greeksofgreeks.linklist;


import com.mohit.leetcode.linklist.ListNode;

public class RearrangeAllEvenAndOddPositioned {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    public static void main(String[] args) {
        RearrangeAllEvenAndOddPositioned sol = new RearrangeAllEvenAndOddPositioned();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        sol.oddEvenList(head);
    }


    public ListNode oddEvenList(ListNode head) {

        if (head == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenStart = even;
        while (odd != null && even != null && even.next != null) {


            // Set Next Odd Position than should be next to even number
            odd.next = even.next;
            // Now move next odd that will be next to even number
            odd = even.next;

            // If odd.next is null means there is not even number than break the loop
            if (odd.next == null) {
                even.next = null;
                odd.next = evenStart;
                break;
            }

            // set the next even number that should be odd next number
            even.next = odd.next;
            //Move to next even number that should be odd next number
            even = odd.next;
        }

        // than add the even list next to the last node off odd list
        odd.next = evenStart;

        return head;
    }

    public Node rearrangeEvenOdd(Node head) {
        // Corner case
        if (head == null)
            return null;

        // Initialize first nodes of even and
        // odd lists
        Node odd = head;
        Node even = head.next;

        // Remember the first node of even list so
        // that we can connect the even list at the
        // end of odd list.
        Node evenFirst = even;

        while (1 == 1) {
            // If there are no more nodes,
            // then connect first node of even
            // list to the last node of odd list
            if (odd == null || even == null ||
                    (even.next) == null) {
                odd.next = evenFirst;
                break;
            }

            // Connecting odd nodes
            odd.next = even.next;
            odd = even.next;

            // If there are NO more even nodes
            // after current odd.
            if (odd.next == null) {
                even.next = null;
                odd.next = evenFirst;
                break;
            }

            // Connecting even nodes
            even.next = odd.next;
            even = odd.next;
        }
        return head;
    }

}

