package com.mohit.leetcode.stack.medium;

import java.util.Stack;

public class VerifyPreorderSerializationofBinaryTree {

    public static void main(String[] args) {
        VerifyPreorderSerializationofBinaryTree sol = new VerifyPreorderSerializationofBinaryTree();
        System.out.println(sol.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }


  /*  public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int store = 1;
        for (String node : nodes) {
            -- store;
            if (store < 0) {
                return false;
            }
            if (!node.equals("#")) {
                store += 2;
            }
        }
        return store == 0;
    }*/

    /**
     *
     * Create a Stack
     * Split the preOrder String with comma
     * Start with first node
     * 1 .if not equal to "#" push into the stack
     * 2 .if equal to "#" than check prev node of the tree means top node the stack or left node the node if null than remove the left also
     * and remove the root node of the both null nodes till top not equal to #
     * 3. Add the null node as removed node in the stack
     */
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return true;
        }

        String[] nodes = preorder.split(",");
        Stack<String> stack = new Stack<>();

        for (String node : nodes) {
            if (node.equals("#")) {
                while (!stack.isEmpty() && stack.peek().equals("#")) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        return false;
                    }

                    stack.pop();
                }
            }

            stack.push(node);
        }

        return stack.size() == 1 && stack.peek().equals("#");
    }
}