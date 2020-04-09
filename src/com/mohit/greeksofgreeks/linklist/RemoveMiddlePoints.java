package com.mohit.greeksofgreeks.linklist;


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

    // This function deletes middle nodes in a sequence of
    // horizontal and vertical line segments represented
    // by linked list.
    Node deleteMiddle() {
        // If only one node or no node...Return back
        if (head == null || head.next == null ||
                head.next.next == null)
            return head;

        Node Next = head.next;
        Node NextNext = Next.next;

        // check if this is vertical or horizontal line
        if (head.x == Next.x) {
            // Find middle nodes with same value as x and
            // delete them.
            while (NextNext != null && Next.x == NextNext.x) {
                head.next = Next.next;
                Next.next = null;

                // Update NextNext for the next iteration
                Next = NextNext;
                NextNext = NextNext.next;
            }
        }

        // if horizontal
        else if (head.y == Next.y) {
            // find middle nodes with same value as y and
            // delete them
            while (NextNext != null && Next.y == NextNext.y) {
                head.next = Next.next;
                Next.next = null;

                // Update NextNext for the next iteration
                Next = NextNext;
                NextNext = NextNext.next;
            }
        }

        // Adjacent points should have same x or same y
        else {
            System.out.println("Given list is not valid");
            return null;
        }

        // recur for other segment

        // temporarily store the head and move head forward.
        Node temp = head;
        head = head.next;

        // call deleteMiddle() for next segment
        this.deleteMiddle();

        // restore head
        head = temp;

        // return the head
        return head;
    }
    /*public Node deleteMiddle() {
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
    }*/

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print("(" + temp.x + "," + temp.y + ")->");
            temp = temp.next;
        }
        System.out.println();
    }
}
