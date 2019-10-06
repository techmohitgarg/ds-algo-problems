package com.mohit.greeksofgreeks.stacks;

import java.util.ListIterator;
import java.util.Stack;

public class Reversestackusingrecursion {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);
        System.out.println("Stack elements before sorting: ");
        printStack(s);
        new Reversestackusingrecursion().sort_stack(s);
        System.out.println(" \n\nStack elements after sorting:");
        printStack(s);

    }


    public void sort_stack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {

            int topValue = stack.pop();
            sort_stack(stack);
            // Insert the greater value at top of the stack
            insert_less_value(stack, topValue);
        }


    }

    private void insert_less_value(Stack<Integer> stack, int topValue) {
        if (stack.isEmpty() || stack.peek() < topValue) {
            stack.push(topValue);
            return;
        }

        int tempOfTopValue = stack.pop();
        insert_less_value(stack, topValue);
        stack.push(tempOfTopValue);

    }

    static void printStack(Stack<Integer> s) {
        ListIterator<Integer> lt = s.listIterator();

        // forwarding
        while (lt.hasNext())
            lt.next();

        // printing from top to bottom
        while (lt.hasPrevious())
            System.out.print(lt.previous() + " ");
    }

}

