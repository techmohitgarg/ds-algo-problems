package com.mohit.linklist;

public class DeleteNodeLinkedList {

    public static void main(String[] args) {
        DeleteNodeLinkedList linkedList = new DeleteNodeLinkedList();
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(3);
        headA.next.next = new ListNode(5);
        headA.next.next.next = new ListNode(7);
//["MyLinkedList","get","addAtIndex","get","get","addAtIndex","get","get"]
//[[],[0],[1,2],[0],[1],[0,1],[0],[1]]

        //[null,-1,null,-1,-1,null,1,-1]
        MyLinkedList myLinkedList = new MyLinkedList();
        System.out.println(myLinkedList.get(0));
        myLinkedList.addAtIndex(1, 2);
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        myLinkedList.addAtIndex(0, 1);
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
