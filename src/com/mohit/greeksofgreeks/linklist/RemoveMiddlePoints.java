package com.mohit.greeksofgreeks.linklist;


import com.mohit.leetcode.linklist.LinkedListSolution;

public class RemoveMiddlePoints {
    Node head;

    class Node {
        int x, y;
        Node next;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
            next = null;
        }
    }

    void push(int x, int y) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(x, y);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    public static void main(String[] args) {
        RemoveMiddlePoints sol = new RemoveMiddlePoints();
        sol.push(40, 5);
        sol.push(20, 5);
        sol.push(10, 5);
        sol.push(10, 8);
        sol.push(10, 10);
        sol.push(3, 10);
        sol.push(1, 10);
        sol.push(0, 10);
        System.out.println("Given list");
        sol.printList();
        sol.deleteMiddle();
        System.out.println("Modify list");
        sol.printList();
    }

    public Node deleteMiddle() {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        Node curr = head;
        while (curr != null && curr.next != null) {
            Node temp = curr;
            if (temp.y == curr.next.y) {
                while (curr.next != null && curr.next.y == temp.y) {
                    curr = curr.next;
                }
                temp.next = curr;
            } else {

                while (curr.next != null && curr.next.x == temp.x) {
                    curr = curr.next;
                }
                temp.next = curr;
            }
        }
        return head;
    }

    Node deleteMiddle_(Node head) {
        if (head == null || head.next == null || head.next.next == null) return head;

        Node curr = head;

        while (curr != null) {
            if (curr.next != null && curr.x == curr.next.x) {
                while (curr != null
                        && curr.next != null
                        && curr.next.next != null
                        && curr.next.x == curr.next.next.x) {
                    curr.next = curr.next.next;
                }
            } else if (curr.next != null && curr.y == curr.next.y) {
                while (curr != null
                        && curr.next != null
                        && curr.next.next != null
                        && curr.next.y == curr.next.next.y) {
                    curr.next = curr.next.next;
                }
            }
            curr = curr.next;
        }


        return head;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print("(" + temp.x + "," + temp.y + ")->");
            temp = temp.next;
        }
        System.out.println();
    }
}
