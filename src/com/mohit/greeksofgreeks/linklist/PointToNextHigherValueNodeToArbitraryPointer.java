package com.mohit.greeksofgreeks.linklist;


public class PointToNextHigherValueNodeToArbitraryPointer {

    static class Node {
        int data;
        Node next, arbit;

        Node(int data) {
            this.data = data;
            next = null;
            arbit = null;
        }
    }

    // Utility function to print result linked list
    void printList(Node node, Node anode) {
        System.out.println("Traversal using Next Pointer");
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

        System.out.println("\nTraversal using Arbit Pointer");
        while (anode != null) {
            System.out.print(anode.data + " ");
            anode = anode.arbit;
        }
    }

    public static void main(String[] args) {
        PointToNextHigherValueNodeToArbitraryPointer sol = new PointToNextHigherValueNodeToArbitraryPointer();
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        Node result = sol.populateArbit(head);
        sol.printList(head, result);
    }


    private Node populateArbit(Node start) {
        if (start == null || start.next == null) return start;

        Node curr = start;
        while (curr != null) {
            curr.arbit = curr.next;
            curr = curr.next;
        }
        return sortList(start);
    }


    public Node sortList(Node head) {
        if (head == null || head.arbit == null) {
            return head;
        }
        Node fast = head;
        Node slow = head;
        Node prev = null;

        // get center
        while (fast != null && fast.arbit != null) {
            prev = slow;
            slow = slow.arbit;
            fast = fast.arbit.arbit;
        }
        prev.arbit = null;
        Node l1 = sortList(head);
        Node l2 = sortList(slow);
        return SortedMerge(l1, l2);
    }

    private Node SortedMerge(Node a, Node b) {
        Node result = null;
        if (a == null)
            return b;
        else if (b == null)
            return a;
        if (a.data <= b.data) {
            result = a;
            result.arbit = SortedMerge(a.arbit, b);
        } else {
            result = b;
            result.arbit = SortedMerge(a, b.arbit);
        }
        return result;
    }

}
