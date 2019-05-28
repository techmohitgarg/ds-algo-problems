package com.mohit.tree.book_practice.generic_trees;

public class Sumofalltheelementsofthetree {

    public static void main(String[] s) {
        Sumofalltheelementsofthetree result = new Sumofalltheelementsofthetree();
        TreeNode node = new TreeNode(1);
        node.chileNode = new TreeNode(2);
        node.nextnode = new TreeNode(3);
        node.nextnode.chileNode = new TreeNode(10);
        node.nextnode.nextnode = new TreeNode(4);
        node.nextnode.nextnode.nextnode = new TreeNode(5);
        node.nextnode.nextnode.nextnode.chileNode = new TreeNode(15);
        node.nextnode.nextnode.nextnode.nextnode = new TreeNode(6);
        System.out.println(result.sumOfAllNode(node));
    }


    public int sumOfAllNode(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + sumOfAllNode(node.chileNode) + sumOfAllNode(node.nextnode);
    }
}
