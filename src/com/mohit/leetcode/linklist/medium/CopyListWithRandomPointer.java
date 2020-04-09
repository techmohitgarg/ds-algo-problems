package com.mohit.leetcode.linklist.medium;


import java.util.HashMap;

public class CopyListWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer sol = new CopyListWithRandomPointer();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        // Set the random pointer
        head.random = head.next.next;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next;

        sol.copyRandomListWithoutUsingMemory(head);
    }


    public Node copyRandomListWithoutUsingMemory(Node head) {
        if (head == null) return null;

        Node curr = head;
        while (curr != null) {

            // Store the next node
            Node next = curr.next;
            // Add the new dummy node to next
            curr.next = new Node(curr.val);
            // Change the point to next to new node
            curr.next.next = next;

            curr = next;
        }

        // Resign the value to curr node
        curr = head;

        // Now the random pointer of the node
        while (curr != null) {
            if (curr.next != null)
                curr.next.random = (curr.random != null) ? curr.random.next : null;
            curr = (curr.next != null) ? curr.next.next : null;
        }
        //Now the original list to copy list

        Node original = head, copy = head.next;
        Node temp = copy;
        while (original != null && copy != null) {
            original.next = (original.next != null) ? original.next.next : null;
            copy.next = (copy.next != null) ? copy.next.next : null;
            original = original.next;
            copy = copy.next;
        }
        return temp;
    }


    public Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();

        Node oldNode = head;
        Node deepNode = new Node(oldNode.val);
        Node itr = deepNode;

        map.put(head, deepNode);


        while (oldNode.next != null) {
            itr.next = new Node(oldNode.next.val);
            map.put(oldNode.next, itr.next);
            oldNode = oldNode.next;
            itr = itr.next;
        }


        oldNode = head;
        itr = deepNode;
        while (oldNode != null) {
            itr.random = map.get(oldNode.random);
            oldNode = oldNode.next;
            itr = itr.next;
        }


        return deepNode;
    }
}
