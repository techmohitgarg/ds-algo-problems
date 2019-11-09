package com.mohit.leetcode.tree.medium;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class SumRoottoLeafNumbers {

    public static void main(String[] s) {
        SumRoottoLeafNumbers leafNumbers = new SumRoottoLeafNumbers();
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(9);
        node.right = new TreeNode(0);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(1);
        System.out.println(leafNumbers.sumNumbers(node));
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return total(root, 0);
    }

    private int total(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = (10 * sum) + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        int left = total(root.left, sum);
        int right = total(root.right, sum);
        return left + right;
    }
    /*int total = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getSum(root, 0);
        return total;
    }

    public void getSum(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum = (sum * 10) + root.val;
        if (root.left == null && root.right == null) {
            total += sum;
        }
        getSum(root.left, sum);
        getSum(root.right, sum);
        sum = (sum / 10);
    }
*/
}
