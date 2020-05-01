package com.mohit.greeksofgreeks.stacks;

import java.util.EmptyStackException;

public class MyStack {
    public static void main(String[] args) {
        MyStack sol = new MyStack();
        StackUsingArray stack = new StackUsingArray(5);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        stack.pop();
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println("----------------------------");
        StackUsingLinkedList stackUsingLinkedList = new StackUsingLinkedList();
        stackUsingLinkedList.push(1);
        System.out.println(stackUsingLinkedList.isEmpty());
        System.out.println(stackUsingLinkedList.size());
        stackUsingLinkedList.pop();
        System.out.println(stackUsingLinkedList.isEmpty());
        System.out.println(stackUsingLinkedList.size());
    }


    public static class StackUsingArray implements StackFeature {
        private int len = 0;
        private int[] stack = null;
        private int top = -1;

        public StackUsingArray(int size) {
            this.len = size;
            stack = new int[size];
        }

        @Override
        public void push(int val) {
            if (top >= len - 1) {
                throw new StackOverflowError();
            } else {
                stack[++top] = val;
            }
        }

        @Override
        public int pop() {
            if (top < 0) {
                throw new EmptyStackException();
            }
            return stack[top--];
        }

        @Override
        public int peek() {
            if (top < 0) {
                return -1;
            }
            return stack[top];
        }

        @Override
        public boolean isEmpty() {
            return top < 0;
        }

        @Override
        public int size() {
            return top + 1;
        }
    }

    static class StackNode {
        int val;
        StackNode next;

        public StackNode(int val) {
            this.val = val;
        }
    }

    public static class StackUsingLinkedList implements StackFeature {

        private int len = 0;
        StackNode head = null;

        public StackUsingLinkedList() {


        }

        @Override
        public void push(int val) {
            StackNode node = new StackNode(val);
            if (head != null) {
                node.next = head;
            }
            head = node;
            len++;
        }

        @Override
        public int pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            int val = head.val;
            head = head.next;
            len--;
            return val;
        }

        @Override
        public int peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return head.val;
        }

        @Override
        public boolean isEmpty() {
            return head == null;
        }

        @Override
        public int size() {
            return len;
        }
    }


    public interface StackFeature {
        void push(int val);

        int pop();

        int peek();

        boolean isEmpty();

        int size();
    }

}
