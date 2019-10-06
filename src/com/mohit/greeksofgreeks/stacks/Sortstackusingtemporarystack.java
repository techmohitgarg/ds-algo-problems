package com.mohit.greeksofgreeks.stacks;

import java.util.ListIterator;
import java.util.Stack;

public class Sortstackusingtemporarystack {

    public static void main(String[] args) {
        int[] num = {34, 3, 31, 98, 92, 23};
        Stack<Integer> s = new Stack<>();
        for (int val : num) {
            s.push(val);
        }
        System.out.println("Stack elements before sorting: ");
        printStack(s);
        new Sortstackusingtemporarystack().sortStackUsingTempStack(s);
        System.out.println("\nStack elements After sorting: ");
        printStack(s);
    }


    // With Out Recursion Solution Solution
    public void sort_Stack_using_temp(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            int top_pop_value = stack.pop();
            while (!temp.isEmpty() && temp.peek() > top_pop_value) {
                stack.push(temp.pop());
            }
            temp.push(top_pop_value);
        }
        // Add All the temp value in the stack
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }


    // With Recursion Solution
    public void sortStackUsingTempStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            int top_pop_value = stack.pop();
            sort_stack(temp, top_pop_value);
        }
        // Add All the temp value in the stack
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    private void sort_stack(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || stack.peek() < value) {
            stack.push(value);
            return;
        }
        int pop_greater_value = stack.pop();
        sort_stack(stack, value);
        stack.push(pop_greater_value);
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

