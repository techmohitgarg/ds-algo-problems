package com.mohit.leetcode.linklist.medium;

public class FlattenMultilevelDoublyLinkedList {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        FlattenMultilevelDoublyLinkedList sol = new FlattenMultilevelDoublyLinkedList();
        Node node = new Node(1);

        node.next = new Node(2);
        node.next.prev = node;

        node.next.next = new Node(3);
        node.next.next.prev = node.next;

        node.next.next.next = new Node(5);
        node.next.next.next.prev = node.next.next;

        node.next.next.next.next = new Node(6);
        node.next.next.next.next.prev = node.next.next.next;

        node.next.next.child = new Node(7);

        node.next.next.child.next = new Node(8);
        node.next.next.child.next.prev = node.next.next.child;

        node.next.next.child.next.next = new Node(9);
        node.next.next.child.next.next.prev = node.next.next.child.next;

        node.next.next.child.next.next.next = new Node(10);
        node.next.next.child.next.next.next.prev = node.next.next.child.next.next;

        node.next.next.child.next.child = new Node(11);

        node.next.next.child.next.child.next = new Node(12);
        node.next.next.child.next.child.next.prev = node.next.next.child.next.child;


        Node result = sol.flatten(node);

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
                p = next;
            }
        }
        return p;
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
