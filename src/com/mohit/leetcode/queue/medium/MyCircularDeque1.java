package com.mohit.leetcode.queue.medium;

public class MyCircularDeque1 {
    int[] deque = null;
    int size = 0;
    int front = -1;
    int rear = -1;
    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    /**
     * insertFront : O(1)
     * insertLast : O(1)
     * deleteFront : O(1)
     * deleteLast : O(1)
     * getFront : O(1)
     * getRear : O(1)
     * isEmpty : O(1)
     * isFull : O(1)
     */

    public MyCircularDeque1(int k) {
        size = k;
        deque = new int[k];
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        if (front == -1 && rear == -1) {
            front++;
            rear++;
        } else if (front == 0) front = size - 1;
        else front--;
        deque[front] = value;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        if (front == -1 && rear == -1) {
            front++;
            rear++;
        } else if (rear == size - 1) rear = 0;
        else rear++;
        deque[rear] = value;

        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        else if (front == rear) front = rear = -1;
        else if (front == size - 1) front = 0;
        else front++;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        else if (front == rear) front = rear = -1;
        else if (rear == 0) rear = size - 1;
        else rear--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (front > -1) return deque[front];
        else return -1;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (rear > -1) return deque[rear];
        else return -1;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return (front == -1 && rear == -1);
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return ((front == 0 && rear == size - 1) || front == rear + 1);
    }

}