package com.mohit.greeksofgreeks.linklist;


public class CompareTwoStrings {

    static class Node {
        char data;
        Node next;

        Node(char d) {
            data = d;
            next = null;
        }
    }


    public static void main(String[] args) {
        CompareTwoStrings sol = new CompareTwoStrings();


        Node a = new Node('g');
        a.next = new Node('e');
        a.next.next = new Node('e');
        a.next.next.next = new Node('k');
        a.next.next.next.next = new Node('s');
        a.next.next.next.next.next = new Node('s');

        Node b = new Node('g');
        b.next = new Node('e');
        b.next.next = new Node('e');

        int value;
        value = sol.compare(a, b);
        System.out.println(value);
    }

    int compare(Node node1, Node node2) {

        // base cases
        if (node1 == null && node2 == null) return 0;
        if (node1 == null) return -1;
        if (node2 == null) return 1;


        Node itr1 = node1;
        Node itr2 = node2;

        while (itr1 != null && itr2 != null && itr1.data == itr2.data) {
            itr1 = itr1.next;
            itr2 = itr2.next;
        }

        if (itr1 != null && itr2 != null) {
            return (itr2.data > itr1.data) ? -1 : 1;
        }

        if (itr1 == null && itr2 != null) return -1;
        if (itr2 == null && itr1 != null) return 1;

        return 0;
    }

}

