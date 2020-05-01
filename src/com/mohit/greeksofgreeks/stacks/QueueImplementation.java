package com.mohit.greeksofgreeks.stacks;

import java.util.Scanner;
import java.util.Stack;

public class QueueImplementation {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }


    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();//stackPush
        Stack<T> stackOldestOnTop = new Stack<T>();//stackPop

        public void pushData(Stack<T> st, T val) {
            st.push(val);
        }

        public void enqueue(T value) { // Push onto newest stack
            pushData(stackNewestOnTop, value);
        }

        public T peek() {
            if (stackNewestOnTop.isEmpty() && stackOldestOnTop.isEmpty()) {
                return null;
            }
            if (stackOldestOnTop.isEmpty()) {
                while (!stackNewestOnTop.isEmpty()) {
                    pushData(stackOldestOnTop, stackNewestOnTop.pop());
                }
            }
            return stackOldestOnTop.peek();
        }

        public T dequeue() {
            if (stackNewestOnTop.isEmpty() && stackOldestOnTop.isEmpty()) {
                return null;
            }
            if (stackOldestOnTop.isEmpty()) {
                while (!stackNewestOnTop.isEmpty()) {
                    pushData(stackOldestOnTop, stackNewestOnTop.pop());
                }
            }
            return stackOldestOnTop.pop();
        }
    }

}
