package com.mohit.tree.book_practice.binary_tree;

public class MakeBinaryTreeWithSpecialProperties {

    public static void main(String[] s) {
        MakeBinaryTreeWithSpecialProperties withSpecialProperties = new MakeBinaryTreeWithSpecialProperties();
        char[] ch = {'I', 'L', 'I', 'L', 'L'};
        TreeNode node = withSpecialProperties.makeTree(ch, 0);
        System.out.println(node);
    }


    public TreeNode makeTree(char[] tree, int i) {
        if (tree == null) {
            return null;
        }

        if (tree.length == i) {
            return null;
        }
        TreeNode newNode = new TreeNode(tree[i]);
        newNode.left = null;
        newNode.right = null;

        if (tree[i] == 'L') {
            return newNode;
        }
        i = i + 1;
        newNode.left = makeTree(tree, i);
        i = i + 1;
        newNode.right = makeTree(tree, i);

        return newNode;
    }

}
