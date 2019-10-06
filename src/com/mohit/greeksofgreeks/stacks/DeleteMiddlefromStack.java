package com.mohit.greeksofgreeks.stacks;

import java.util.Stack;

public class DeleteMiddlefromStack {

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6};
        Stack<Integer> s = new Stack<>();
        for (int val : num) {
            s.push(val);
        }
        //new Solution().delete_middle_stack(s);
        new DeleteMiddlefromStack().delete_middle_stack_using_recursion(s, s.size() / 2, 0);
        System.out.println(s);
    }

    public void delete_middle_stack_using_recursion(Stack<Integer> stack, int mid, int start) {
        if (start == mid || stack.isEmpty()) {
            // Pop the middle element from stack when (start== mid)
            if (!stack.isEmpty()) stack.pop();
            return;
        }
        int top_pop_element = stack.pop();
        delete_middle_stack_using_recursion(stack, mid, start + 1);
        // Push Back the pop element in the stack expect middle element
        stack.push(top_pop_element);
    }


    // Without Recursion Solution
    public void delete_middle_stack(Stack<Integer> stack) {
        int len = stack.size();

        int mid = (len / 2);
        Stack<Integer> temp = new Stack<>();

        while (mid > 0 && !stack.isEmpty()) {
            temp.push(stack.pop());
            mid--;
        }
        //remove middle element from stack
        stack.pop();
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        System.out.println(stack);
    }


}

