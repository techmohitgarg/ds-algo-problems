package com.mohit.linklist;

import java.util.ArrayList;
import java.util.List;

class MyLinkedList {


    List<Integer> list;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        list = new ArrayList();
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (list.size() == 0 || list.size() <= index) {
            return -1;
        }
        return list.get(index);
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if (list.size() == 0) {
            list.add(val);
        } else {
            list.add(0, val);
        }
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        list.add(val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == list.size()) {
            list.add(val);
        } else if (list.size() > index) {
            list.add(index, val);
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (list.size() > index) {
            list.remove(index);
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */