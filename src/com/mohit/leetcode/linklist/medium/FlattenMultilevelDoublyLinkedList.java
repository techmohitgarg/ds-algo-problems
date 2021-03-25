package com.mohit.leetcode.linklist.medium;

import com.mohit.leetcode.linklist.LinkedUtil;
import com.mohit.leetcode.linklist.Node;

public class FlattenMultilevelDoublyLinkedList {


    public static void main(String[] args) {
        FlattenMultilevelDoublyLinkedList sol = new FlattenMultilevelDoublyLinkedList();
        Node first = LinkedUtil.makeNode(new int[]{1, 2, 3, 4, 5, 6});
        Node second = LinkedUtil.makeNode(new int[]{7, 8,9,10});
        Node third = LinkedUtil.makeNode(new int[]{11, 12});

        first.next.next.child = second;
        second.next.child = third;

        Node result = sol.flatten(first);

        System.out.println(result);
    }

    public Node flatten(Node head) {
        if (head == null) return null;
        helper(head);
        return head;
    }

    // Without using recursion
    public Node helper(Node head) {
        Node p = head;
        while (p != null) {
            if (p.child == null) {
                if (p.next != null) {
                    p = p.next;
                } else {
                    return p;
                }
            } else {
                Node next = p.next;
                p.next = p.child;
                p.child.prev = p;
                p.child = null;
                Node prev = helper(p.next);
                if (next != null) {
                    prev.next = next;
                    next.prev = prev;
                }
                if (next != null)
                    p = next;
                else {
                    p = prev;
                }
            }
        }
        return p;
    }

    public static Node flatten1(Node head) {
        if (head == null) return head;

        Node itr = head;
        Node next = null;
        while (itr != null) {
            if (itr.child != null) {
                next = itr.next;
                itr.next = flatten1(itr.child);
                itr.child = null;
                if (itr.next != null)
                    itr.next.prev = itr;

                while (itr.next != null) {
                    itr = itr.next;
                }
                if (itr.next == null) {
                    itr.next = next;
                    if (itr.next != null)
                        itr.next.prev = itr;
                }
            }
            itr = itr.next;
        }
        return head;
    }
   /* public Node flatten(Node head) {
        if (head == null) return null;

        Stack<Node> st = new Stack<>();
        st.push(head);
        Node prev = null;
        while (!st.isEmpty()) {
            Node temp = st.pop();
            // Set prev Node of the current node
            temp.prev = prev;
            // Set the next node
            if (prev != null) {
                prev.next = temp;
                prev.child=null;
            }

            // Push the next node into the stack than push the child node into the stack
            // Because we need to process child first than next
            if (temp.next != null) {
                st.push(temp.next);
            }
            if (temp.child != null) {
                st.push(temp.child);
            }
            prev = temp;

        }
        if (st.isEmpty()) {
            prev.next = null;
        }
        return head;
    }*/


}
