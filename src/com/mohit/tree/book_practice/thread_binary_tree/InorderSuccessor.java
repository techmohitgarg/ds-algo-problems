package com.mohit.tree.book_practice.thread_binary_tree;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class InorderSuccessor {


    public static void main(String[] s) {

        InorderSuccessor successor = new InorderSuccessor();
        Node root = null, temp = null, suc = null, min = null;
        root = successor.insert(root, 20);
        root = successor.insert(root, 8);
        root = successor.insert(root, 22);
        root = successor.insert(root, 4);
        root = successor.insert(root, 12);
        root = successor.insert(root, 10);
        root = successor.insert(root, 14);
        temp = root.left.right;
        suc = successor.inOrderSuccessorWithOutRoot(root, temp);
        TreeNode tt = new TreeNode(1);
        tt.left = new TreeNode(2);
        tt.right = new TreeNode(3);
        tt.left.left = new TreeNode(4);
        tt.left.right = new TreeNode(5);
        tt.right.right = new TreeNode(6);

        if (suc != null) {
            /*System.out.println("Inorder successor of " + temp.data +
                    " is " + successor.inOrderSuccessorUsingRoot(root, temp).data);
            System.out.println("Inorder successor of " + temp.data +
                    " is " + successor.inOrderSuccessorWithOutRoot(root, temp).data);*/

            successor.findInorderRecursive(tt, tt.left.left);

        } else {
            System.out.println("Inorder successor does not exist");
        }
    }

    Node temp = null;

    public Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        // Left SubTree
        if (data <= root.data) {
            temp = insert(root.left, data);
            root.left = temp;
            temp.parent = root;
        } else {
            temp = insert(root.right, data);
            root.right = temp;
            temp.parent = root;
        }
        return root;

    }

    public TreeNode findInorderRecursive(TreeNode root, TreeNode x) {
        if (root == null)
            return null;
        TreeNode temp = null;
        if (root == x || (temp = findInorderRecursive(root.left, x)) != null ||
                (temp = findInorderRecursive(root.right, x)) != null) {
            if (temp != null) {
                if (root.left == temp) {
                    System.out.print("Inorder Successor of " + x.val);
                    System.out.print(" is " + root.val + "\n");
                    return null;
                }
            }
            return root;
        }

        return null;
    }


    public Node inOrderSuccessorUsingRoot(Node root, Node node) {
        if (node.right != null) {
            Node temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        } else {
            Node succ = null;
            while (root != null) {
                if (node.data < root.data) {
                    succ = root;
                    root = root.left;
                } else if (node.data > root.data)
                    root = root.right;
                else
                    break;
            }
            return succ;
        }

    }

    public Node inOrderSuccessorWithOutRoot(Node root, Node node) {
        if (node.right != null) {
            Node temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        } else {
            Node p = node.parent;
            while (p != null && p.right == node) {
                node = p;
                p = node.parent;
            }
            return p;
        }

    }


}
