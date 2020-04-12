package com.mohit.greeksofgreeks.linklist;


import java.util.Stack;

public class FlattenMultiLevelLinkedList2 {
    static class Node {
        int data;
        Node next, down;

        Node(int data) {
            this.data = data;
            next = null;
            down = null;
        }
    }

    public static void main(String[] args) {
        FlattenMultiLevelLinkedList2 sol = new FlattenMultiLevelLinkedList2();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.down = new Node(7);
        head.next.down.down = new Node(9);
        head.next.down.down.down = new Node(14);
        head.next.down.down.down.down = new Node(15);
        head.next.down.down.down.down.next = new Node(23);
        head.next.down.down.down.down.next.down = new Node(24);
        head.next.down.next = new Node(8);
        head.next.down.next.down = new Node(16);
        head.next.down.next.down.down = new Node(17);
        head.next.down.next.down.down.next = new Node(18);
        head.next.down.next.down.down.next.next = new Node(19);
        head.next.down.next.down.down.next.next.next
                = new Node(20);
        head.next.down.next.down.down.next.next.next.down
                = new Node(21);
        head.next.down.next.next = new Node(10);
        head.next.down.next.next.down = new Node(11);
        head.next.down.next.next.next = new Node(12);

        head = sol.flattenList2(head);
        printFlattenNodes(head);
    }


    public static void printFlattenNodes(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }

    }

    Node last = null;

    public Node flattenList(Node node) {
        if (node == null) return node;

        last = node;

        Node next = node.next;

        if (node.down != null)
            node.next = flattenList(node.down);

        if (next != null)
            last.next = flattenList(next);

        return node;
    }

    Node flattenList2(Node head) {
        Node headcop = head;
        Stack<Node> save = new Stack<>();
        save.push(head);
        Node prev = null;

        while (!save.empty()) {
            Node temp = save.peek();
            save.pop();

            if (temp.next != null)
                save.push(temp.next);
            if (temp.down != null)
                save.push(temp.down);

            if (prev != null)
                prev.next = temp;

            prev = temp;
        }
        return headcop;
    }


}

