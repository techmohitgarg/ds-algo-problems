package com.mohit.leetcode.tree.easy;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.List;

public class SumofRootToLeafBinaryNumbers {


    public static void main(String[] args) {
        TreeNode t1 = MakeTree.stringToTreeNode("[1,0,1,0,1,0,1]");
        System.out.println(new SumofRootToLeafBinaryNumbers().sumRootToLeaf(t1));
    }

    int sum = 0;

    //region Sum of Root To Leaf Binary Numbers
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        sumRootToLeaf(root, 0);
        return sum;
    }

    public void sumRootToLeaf(TreeNode root, int sum) {
        if (root == null) return;

        sum = (sum * 2) + root.val;
        sumRootToLeaf(root.left, sum);
        sumRootToLeaf(root.right, sum);
        if (root.left == null && root.right == null) {
            this.sum += sum;
        }
    }
    /*public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        sumRootToLeaf(root, new ArrayList<>());
        return sum;
    }*/

    /*public void sumRootToLeaf(TreeNode root, List<Integer> list) {
        if (root == null) return;

        list.add(root.val);
        sumRootToLeaf(root.left, list);
        sumRootToLeaf(root.right, list);
        if (root.left == null && root.right == null) {
            int decimal = 0;
            int i = 0;
            for (int j = list.size() - 1; j >= 0; j--) {
                decimal += Math.pow(2, i) * list.get(j);
                i++;
            }
            sum += decimal;
        }
        list.remove(list.size() - 1);
    }

    //endregion
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        sum = printGetAllPath("", root);
        return sum;
    }

    private int printGetAllPath(String binaryString, TreeNode root) {
        if (root == null) return 0;
        binaryString += root.val;
        int left = printGetAllPath(binaryString, root.left);
        int right = printGetAllPath(binaryString, root.right);
        int sum = 0;
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(binaryString, 2);
        }
        return sum + left + right;
    }*/

}